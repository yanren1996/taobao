package com.example.taobao.repository;

import com.example.taobao.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    <T> T findByEmail(String email, Class<T> type);

//    Page<UserEntity> findAll(Pageable pageable);

    /**
     * 查詢全部 (findAll不支援 返回非Entity類型資料，而我們想返回VO)
     */
    <T> Page<T> findByEmailNotNull(Pageable pageable, Class<T> type);

    boolean existsByEmail(String email);

}
