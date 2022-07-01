package app.interfaces;

import java.util.List;

public interface IABML <T>{
	public void create(T obj);
	public T readOne(int id);
	public List<T>readAll();
	public List<T>readMany(String param);
	public void update(T obj);
	public void delete(T obj);
}
