package shit.ssm1.mybatis;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author GongTengPangYi
 */
public interface BaseService<T extends Serializable, E extends Serializable> {

    int deleteByPrimaryKey(E id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(E id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}
