package br.unip.ads.gof.singleton;

public class SingletonApressado {
	
	private static SingletonApressado intancia = new SingletonApressado();
	
	private SingletonApressado() {
		super();
	}
	
	public static SingletonApressado getIntancia() {
		return SingletonApressado.intancia;
	}
}
