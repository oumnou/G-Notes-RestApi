package estm.dsic.jee.rest.dao;

public interface Reposistory<T,I> {
  

    T create(T entity);
    void delete(T entity);
    void update(T entity);
    
    T auth(T entity);
    T find(T entity, I index);


}
