package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-10-22T10:30:57.245+0200")
@StaticMetamodel(Position.class)
public class Position_ {
	public static volatile SingularAttribute<Position, String> emplacement;
	public static volatile SingularAttribute<Position, Integer> etat;
	public static volatile SingularAttribute<Position, String> lattitude;
	public static volatile SingularAttribute<Position, String> longitude;
	public static volatile SingularAttribute<Position, Colis> coli;
	public static volatile SingularAttribute<Position, Integer> idposition;
}