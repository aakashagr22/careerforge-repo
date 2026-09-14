package com.careerforge.user.controller;

import com.careerforge.common.dto.ApiResponse;
import com.careerforge.user.dto.UpdateUserRoleRequest;
import com.careerforge.user.dto.UserDto;
import com.careerforge.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/admin/users")
@Tag(name = "User Management (Admin)", description = "Admin APIs for managing users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user details by ID")
    public ResponseEntity<ApiResponse<UserDto>> getUserById(@PathVariable UUID id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(ApiResponse.success(userDto, "User details retrieved successfully"));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user details")
    public ResponseEntity<ApiResponse<UserDto>> updateUser(@PathVariable UUID id, @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(ApiResponse.success(updatedUser, "User details updated successfully"));
    }

    @PostMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate user account")
    public ResponseEntity<ApiResponse<Void>> deactivateUser(@PathVariable UUID id) {
        userService.deactivateUser(id);
        return ResponseEntity.ok(ApiResponse.success("User account deactivated successfully"));
    }

    @PostMapping("/{id}/activate")
    @Operation(summary = "Activate user account")
    public ResponseEntity<ApiResponse<Void>> activateUser(@PathVariable UUID id) {
        userService.activateUser(id);
        return ResponseEntity.ok(ApiResponse.success("User account activated successfully"));
    }

    @PatchMapping("/{id}/role")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Promote or change user role (Admin only)")
    public ResponseEntity<ApiResponse<UserDto>> updateUserRole(@PathVariable UUID id, @Valid @RequestBody UpdateUserRoleRequest request) {
        UserDto updatedUser = userService.updateUserRole(id, request.getRole());
        return ResponseEntity.ok(ApiResponse.success(updatedUser, "User role updated successfully"));
    }
}
