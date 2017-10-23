package org.liufree.dao.test;

import org.liufree.bean.test.Test1;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lwx
 * @date 7/20/17
 * @email liufreeo@gmail.com
 */
public interface TestDao  extends JpaRepository<Test1,Integer>{

}
