package com.gjozef.devicesservice.repository;

import com.gjozef.devicesservice.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findByIdAndDeviceIdAndActiveTrue(Long commentId, Long deviceId);

    List<Comment> findAllByDeviceIdAndActiveTrue(Long deviceId);
}
