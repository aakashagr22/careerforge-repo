package com.careerforge.chat.validator;

import com.careerforge.chat.entity.ChatRoom;
import com.careerforge.chat.entity.RoomType;
import com.careerforge.exception.BadRequestException;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.user.entity.Role;
import com.careerforge.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Validates whether a user has access to a specific chat room.
 * <p>
 * Access rules:
 * - ADMIN: full access to every room
 * - GENERAL_CHAT / SENIOR_CHAT: all active students can access
 * - YEAR_CHAT: only students whose semester falls within the room's year group
 *   (year 1 = semesters 1-2, year 2 = semesters 3-4, year 3 = semesters 5-6, year 4 = semesters 7-8)
 *   If the room has no yearGroup set, all students can access it.
 * - PRIVATE_CHAT: handled separately via conversation membership
 */
@Component
public class ChatAccessValidator {

    private static final Logger log = LoggerFactory.getLogger(ChatAccessValidator.class);
    private final StudentProfileRepository studentProfileRepository;

    public ChatAccessValidator(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    /**
     * Checks if the given user can access the specified chat room.
     */
    public boolean canAccessRoom(User user, ChatRoom chatRoom) {
        // Admins have full access to all rooms
        if (user.getRole() == Role.ADMIN) {
            log.debug("Admin user {} granted access to room {}", user.getId(), chatRoom.getId());
            return true;
        }

        if (!chatRoom.isActive()) {
            log.debug("Room {} is inactive, denying access for user {}", chatRoom.getId(), user.getId());
            return false;
        }

        return switch (chatRoom.getRoomType()) {
            case GENERAL_CHAT, SENIOR_CHAT -> true;
            case YEAR_CHAT -> canAccessYearChat(user, chatRoom);
            case PRIVATE_CHAT -> false; // Private chats are handled via conversation endpoints
        };
    }

    /**
     * Checks if a student's semester matches the room's year group.
     * Year 1 = semesters 1-2, Year 2 = semesters 3-4, etc.
     * If the room has no yearGroup set (null), all students can access it.
     */
    private boolean canAccessYearChat(User user, ChatRoom chatRoom) {
        Integer yearGroup = chatRoom.getYearGroup();

        // If no year group is set on this room, allow all students
        if (yearGroup == null) {
            return true;
        }

        // Look up the student's semester
        return studentProfileRepository.findByUserId(user.getId())
                .map(profile -> {
                    Integer semester = profile.getSemester();
                    if (semester == null) {
                        // If semester is not set on the student profile, allow access
                        return true;
                    }
                    // Calculate which year the student's semester belongs to
                    // Semester 1-2 → Year 1, Semester 3-4 → Year 2, etc.
                    int studentYear = (semester + 1) / 2;
                    boolean hasAccess = studentYear == yearGroup;
                    if (!hasAccess) {
                        log.debug("Student {} (semester {}, year {}) denied access to year {} room {}",
                                user.getId(), semester, studentYear, yearGroup, chatRoom.getName());
                    }
                    return hasAccess;
                })
                .orElse(true); // If no student profile found, allow access
    }

    /**
     * Validates and throws if user cannot access the room.
     */
    public void validateRoomAccess(User user, ChatRoom chatRoom) {
        if (!canAccessRoom(user, chatRoom)) {
            throw new BadRequestException("You do not have access to this chat room. " +
                    "This room is restricted to Year " + chatRoom.getYearGroup() + " students.");
        }
    }
}
