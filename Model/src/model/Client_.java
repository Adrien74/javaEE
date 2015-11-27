package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-11-25T11:30:17.517+0100")
@StaticMetamodel(Client.class)
public class Client_ {
	public static volatile SingularAttribute<Client, Integer> idClient;
	public static volatile SingularAttribute<Client, Boolean> isAdmin;
	public static volatile SingularAttribute<Client, String> login;
	public static volatile SingularAttribute<Client, String> password;
	public static volatile ListAttribute<Client, Colis> colis;
}
