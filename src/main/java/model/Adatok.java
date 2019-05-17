package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Adatok")
public class Adatok {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "Tipus")
	private String tipus;

	@Column(name = "Szam1")
	private long szam1;

	@Column(name = "Szam2")
	private long szam2;

	@Column(name = "Szam3")
	private long szam3;

	@Column(name = "Eredmeny")
	private long eredmeny;

	@Column(name = "EredmenyS")
	private String eredmenyS;

	public Adatok() {
	}

	public Adatok(String tipus, long szam1, long szam2, long eredmeny) {
		this.tipus = tipus;
		this.szam1 = szam1;
		this.szam2 = szam2;
		this.eredmeny = eredmeny;
	}

	public Adatok(String tipus, long szam1, long szam2, long szam3, String eredmenyS) {
		this.tipus = tipus;
		this.szam1 = szam1;
		this.szam2 = szam2;
		this.szam3 = szam3;
		this.eredmenyS = eredmenyS;
	}

	public List<Adatok> getAllAdat() throws Exception{
		EntityManager em;
		System.out.println("Adatok lista...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
		em = emf.createEntityManager();
		try{

			TypedQuery<Adatok> q = em.createQuery("SELECT e FROM Adatok e ", Adatok.class);
			List<Adatok> result = q.getResultList();
			if(result.size() > 0)
			{
				return result;
			}
			return null;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}
