package shit.ssm1.mybatis;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author GongTengPangYi
 */
public interface BaseService<T extends Serializable, E extends Serializable> {

    public void save(T t);

    public void update(T t);

    public boolean delete(T t);

    public T findById(E e);

    public List<T> findAll();

}
