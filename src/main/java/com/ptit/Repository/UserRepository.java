
package com.ptit.Repository;

import com.ptit.Entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,String> {
    User getUserByEmail(String email);
    Page<User> findAllByOrderByEmailDesc(Pageable pageable);
    User findUserByEmail(String email);


//    @Query(
//            value = "select * from dbo_users",
//            nativeQuery = true
//    )

   // List<User> getAllUser();



}
