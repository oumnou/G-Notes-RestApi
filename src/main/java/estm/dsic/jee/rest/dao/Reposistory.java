package estm.dsic.jee.rest.dao;

public interface Reposistory<T,I> {
  

    void create(T entity);
    T auth(T entity);
    T find (T entity,I index);
    void delete(T entity);
    void update(T entity);


}
