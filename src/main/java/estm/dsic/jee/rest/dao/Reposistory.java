package estm.dsic.jee.rest.dao;

public interface Reposistory<T,I> {
    //T pour la table (note ou user) et I pour index de recherche soit(email pour user ou bien id pour note )

  
    // default void create(T entity){
    //     //methoide predefinie 
    // }
    void create(T entity);
    T auth(T entity);
    T find (T entity,I index);
    void delete(T entity,I index);
    void update(T entity,I index);


}
