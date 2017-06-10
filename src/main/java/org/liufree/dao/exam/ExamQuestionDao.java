package org.liufree.dao.exam;

import org.liufree.bean.exam.ExamQuestion;
import org.liufree.bean.exam.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author lwx
 * @date 6/9/17
 * @email liufreeo@gmail.com
 */
public interface ExamQuestionDao extends JpaRepository<ExamQuestion,Integer> {

    @Query("select q from ExamQuestion q where q.examId=:examId")
    List<ExamQuestion> getQuestionByExamId(@Param("examId") int examId);

}
