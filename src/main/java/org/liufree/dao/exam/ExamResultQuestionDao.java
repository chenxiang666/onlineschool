package org.liufree.dao.exam;

import org.liufree.bean.exam.ExamResultQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author lwx
 * @date 6/25/17
 * @email liufreeo@gmail.com
 */
public interface ExamResultQuestionDao extends JpaRepository<ExamResultQuestion,Integer>{


    @Query("select q from ExamResultQuestion q where q.examId=:examId")
    List<ExamResultQuestion> findByExamId(@Param("examId") int examId);

    @Query("select eq from ExamResultQuestion eq  where eq.userId=:userId and eq.examId=:examId")
    List<ExamResultQuestion> getByUserIdAndExamId(@Param("userId") int userId, @Param("examId") int examId);

    @Query("select eq from ExamResultQuestion eq  where eq.examResultId=:examResultId")
    List<ExamResultQuestion> getByExamResultId(@Param("examResultId") int examResultId);

    @Modifying
    @Transactional
    @Query("delete from ExamResultQuestion erq where erq.examId=:examId")
    void deleteByExamId(@Param("examId") int examId);
}
