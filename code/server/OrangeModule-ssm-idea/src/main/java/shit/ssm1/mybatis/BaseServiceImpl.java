package shit.ssm1.mybatis;

import java.io.Serializable;

/**
 * @author GongTengPangYi
 */
public abstract class BaseServiceImpl<T extends Serializable, E extends Serializable> implements BaseService<T, E> {

    public abstract BaseMapper<T, E> getMapper();

    @Override
    public int deleteByPrimaryKey(E id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        return getMapper().insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return getMapper().insertSelective(record);
    }

    @Override
    public T selectByPrimaryKey(E id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return updateByPrimaryKey(record);
    }
}
