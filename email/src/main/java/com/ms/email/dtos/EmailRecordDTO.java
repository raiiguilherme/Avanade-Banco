package com.ms.email.dtos;


public record EmailRecordDTO(
        Long userId,
        String emailTo,
        String subject,
        String text
) {
}
