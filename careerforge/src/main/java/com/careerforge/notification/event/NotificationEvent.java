package com.careerforge.notification.event;

import com.careerforge.student.entity.StudentProfile;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class NotificationEvent extends ApplicationEvent {
    private final StudentProfile student;
    private final String message;

    public NotificationEvent(Object source, StudentProfile student, String message) {
        super(source);
        this.student = student;
        this.message = message;
    }
}
