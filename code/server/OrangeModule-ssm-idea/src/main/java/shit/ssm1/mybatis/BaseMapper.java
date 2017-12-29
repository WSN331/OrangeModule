package shit.ssm1.mybatis;

import org.apache.ibatis.annotations.InsertProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author GongTengPangYi
 */
@Repository("baseMapper")
public interface BaseMapper {

    List<Map<String,Object>> selectFirst(Map<String,Object> param);

    int delete(Map<String,Object> param);

    int insert(Map<String,Object> param);

    int update(Map<String,Object> param);

    List<Map<String,Object>> selectList(Map<String,Object> param);
}
