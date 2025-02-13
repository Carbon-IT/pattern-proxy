package com.exo.cupidon.model;

import java.time.LocalDateTime;

public record Message(User sender, User recipient, String message, LocalDateTime createdAt) {
}
