package model;

public class Szamitasok {

	static long x, y;

	public Szamitasok() {
	}

	//Szamitasok(String tipus, long szam1, long szam2, long eredmeny)

	/* Legnagyobb közös osztó: Euklidészi algoritmus */
	public static long lnko(long szam1, long szam2) {
		long tmp;
		while (szam2 > 0) {
			tmp = szam2;
			szam2 = szam1 % szam2;
			szam1 = tmp;
		}
		return szam1;
	}

	public static long lnkoExt(long szam1, long szam2) {
		long q, r, xx, yy, sign;
		long[] xs = {1, 0};
		long[] ys = {0, 1};
		sign = 1;
		while (szam2 != 0) {
			r = szam1 % szam2;
			q = szam1 / szam2;
			szam1 = szam2;
			szam2 = r;
			xx = xs[1];
			yy = ys[1];
			xs[1] = (q * xs[1] + xs[0]);
			ys[1] = (q * ys[1] + ys[0]);
			xs[0] = xx;
			ys[0] = yy;
			sign = -sign;
		}
		x = sign * xs[0];
//		System.out.println("X: " + x);
		y = -sign * ys[0];
//		System.out.println("Y: " + y);
		return szam1;
	}

	/* moduláris gyorshatványozás*/
	static long hatvany(long alap, long kitevo, long p) {
		long ertek = 1;
		alap = alap % p;

		while (kitevo > 0) {
			if ((kitevo & 1) == 1) {
				ertek = (ertek * alap) % p;
			}
			kitevo = kitevo >> 1;
			alap = (alap * alap) % p;
		}
		return ertek;
	}

	/* gyorshatványozás*/
	static long hatvanyGyors(long alap, long kitevo) {
		long ertek = 1;
		while (kitevo > 0) {
			if ((kitevo & 1) == 1) {
				ertek = ertek * alap;
			}
			alap = alap * alap;
			kitevo = kitevo / 2;
		}
		return ertek;
	}


	/* Miller-Rabin teszt */
	static boolean tesztMillerRabin(long n, long d, long a) {
		long x = hatvany(a, d, n);

		if (x == 1 || x == n - 1)
			return true;

		while (d != n - 1) {
			x = (x * x) % n;
			d *= 2;

			if (x == 1)
				return false;
			if (x == n - 1)
				return true;
		}
		return false;
	}

	public static boolean primTesztN(long n, int k) {
		if (n <= 1)
			return false;
		else if (n <= 3)
			return true;
		else if ((n % 2) == 0)
			return false;

		long d = n - 1;

		while (d % 2 == 0)
			d /= 2;

		for (int i = 1; i <= k; i++) {
			long a = 2 + (long)(Math.random() % (n - 4));
			if (!tesztMillerRabin(n ,d, a))
				return false;
		}

		return true;
	}

	public static boolean primTeszt2(long n, long a1, long a2) {
		if (n <= 1)
			return false;
		else if (n <= 3)
			return true;
		else if ((n % 2) == 0)
			return false;

		long d = n - 1;

		while (d % 2 == 0)
			d /= 2;

		if (!tesztMillerRabin(n ,d, a1)) {
			return false;
		} else {
			return tesztMillerRabin(n ,d, a2);
		}
	}

	public static boolean primTeszt(long n, long a) {
		if (n <= 1)
			return false;
		else if (n <= 3)
			return true;
		else if ((n % 2) == 0)
			return false;

		long d = n - 1;

		while (d % 2 == 0)
			d /= 2;

		return tesztMillerRabin(n ,d, a);
	}

	public static long rsaN(long p, long q) {
		return p * q;
	}

	public static long rsaFi(long p, long q) {
		return (p -1) * (q -1);
	}

	public static long rsaD(long e, long fi) {
		lnkoExt(e, fi);
		if (x < 0)
			return x + fi;
		else
			return x;
	}

	public static long rsaE(long[] eT, long fi) {
		for (long ex : eT)
		{
			if ((ex < fi) && lnko(ex, fi)==1)
				return ex;
		}
		return 0;
	}

	public static long rsaDec(long c, long n, long d) {
		return hatvany(c,d,n);
	}

	public static long rsaDec2(long c, long n, long d) {
		return hatvanyGyors(c,d) % n;
	}

	public static long rsaEnc(long m, long n, long e) {
		return hatvany(m,e,n);
	}

	public static long rsaEnc2(long m, long n, long e) {
		return hatvanyGyors(m,e) % n;
	}

	public static long rsaED(long d, long fi) {
		lnkoExt(d, fi);
		if (x < 0)
			return x + fi;
		else
			return x;
	}


}
