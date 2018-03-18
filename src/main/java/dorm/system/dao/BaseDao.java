package dorm.system.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 基础数据库操作类
 * @author 骆润贻
 *
 * @param <T>
 */
public interface BaseDao<T> {
	
	//保存一个对象
	public void save(T t);
	
	//删除一个对象
	public void delete(T t);
	
	//更新一个对象
	public void update(T t);
	
	//通过主键获取一个对象
	public T get(Class<T> c,Serializable id);
	
	// 通过HQL语句获取一个对象	 
	public T get(String hql);

	// 通过HQL语句获取一个对象
	public T get(String hql, Map<String, Object> params);

	// 获得对象列表
		public List<T> find(String hql);

	//获得对象列表
	public List<T> find(String hql, Map<String, Object> params);

	public int executeSql(String sql);
	
	/**
	 * 获得分页后的对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @param page
	 *            要显示第几页
	 * @param rows
	 *            每页显示多少条
	 * @return List
	 */
	public List<T> find(String hql, int page, int rows);

	/**
	 * 获得分页后的对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数
	 * @param page
	 *            要显示第几页
	 * @param rows
	 *            每页显示多少条
	 * @return List
	 */
	public List<T> find(String hql, Map<String, Object> params, int page, int rows);
	
	
	
}
