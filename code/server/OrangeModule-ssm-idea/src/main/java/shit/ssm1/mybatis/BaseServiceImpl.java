package shit.ssm1.mybatis;

import shit.helper.ShitReflectHelper;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author GongTengPangYi
 */
public class BaseServiceImpl<T extends Serializable, E extends Serializable> implements BaseService<T, E> {

    protected Class<T> entityClass;

    @Resource(name = "baseMapper")
    private BaseMapper baseMapper;

    public BaseServiceImpl() {
        this.entityClass = ShitReflectHelper.getSuperClassGenericType(getClass(), 0);
    }

    @Override
    public void save(T t) {

    }

    @Override
    public void update(T t) {

    }

    @Override
    public boolean delete(T t) {
        return false;
    }

    @Override
    public T findById(E e) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
