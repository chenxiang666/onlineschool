package org.liufree.dao.exam;

import org.liufree.bean.exam.ExamResultQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author lwx
 * @date 6/25/17
 * @email liufreeo@gmail.com
 */
public interface ExamResultQuestionDao extends JpaRepository<ExamResultQuestion,Integer>{


    @Query("select q from ExamResultQuestion q where q.examId=:examId")
    List<ExamResultQuestion> findByExamId(@Param("examId") int examId);
}
