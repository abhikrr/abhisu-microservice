package com.abhisu.microservice.test.entityrelation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestTeacherRepository extends JpaRepository<TestTeacher, Integer> {
}
