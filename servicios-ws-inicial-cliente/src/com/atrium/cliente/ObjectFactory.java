package com.atrium.cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.atrium.cliente package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _FechaActualResponse_QNAME = new QName(
			"http://servicio.atrium.com/", "fecha_ActualResponse");
	private final static QName _Saludo_QNAME = new QName(
			"http://servicio.atrium.com/", "saludo");
	private final static QName _FechaActual_QNAME = new QName(
			"http://servicio.atrium.com/", "fecha_Actual");
	private final static QName _SaludoResponse_QNAME = new QName(
			"http://servicio.atrium.com/", "saludoResponse");
	private final static QName _Sumar_QNAME = new QName(
			"http://servicio.atrium.com/", "sumar");
	private final static QName _SumarResponse_QNAME = new QName(
			"http://servicio.atrium.com/", "sumarResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.atrium.cliente
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link FechaActual }
	 * 
	 */
	public FechaActual createFechaActual() {
		return new FechaActual();
	}

	/**
	 * Create an instance of {@link FechaActualResponse }
	 * 
	 */
	public FechaActualResponse createFechaActualResponse() {
		return new FechaActualResponse();
	}

	/**
	 * Create an instance of {@link Sumar }
	 * 
	 */
	public Sumar createSumar() {
		return new Sumar();
	}

	/**
	 * Create an instance of {@link Saludo }
	 * 
	 */
	public Saludo createSaludo() {
		return new Saludo();
	}

	/**
	 * Create an instance of {@link SaludoResponse }
	 * 
	 */
	public SaludoResponse createSaludoResponse() {
		return new SaludoResponse();
	}

	/**
	 * Create an instance of {@link SumarResponse }
	 * 
	 */
	public SumarResponse createSumarResponse() {
		return new SumarResponse();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link FechaActualResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://servicio.atrium.com/", name = "fecha_ActualResponse")
	public JAXBElement<FechaActualResponse> createFechaActualResponse(
			FechaActualResponse value) {
		return new JAXBElement<FechaActualResponse>(_FechaActualResponse_QNAME,
				FechaActualResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Saludo }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://servicio.atrium.com/", name = "saludo")
	public JAXBElement<Saludo> createSaludo(Saludo value) {
		return new JAXBElement<Saludo>(_Saludo_QNAME, Saludo.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link FechaActual }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://servicio.atrium.com/", name = "fecha_Actual")
	public JAXBElement<FechaActual> createFechaActual(FechaActual value) {
		return new JAXBElement<FechaActual>(_FechaActual_QNAME,
				FechaActual.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link SaludoResponse }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://servicio.atrium.com/", name = "saludoResponse")
	public JAXBElement<SaludoResponse> createSaludoResponse(SaludoResponse value) {
		return new JAXBElement<SaludoResponse>(_SaludoResponse_QNAME,
				SaludoResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Sumar }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://servicio.atrium.com/", name = "sumar")
	public JAXBElement<Sumar> createSumar(Sumar value) {
		return new JAXBElement<Sumar>(_Sumar_QNAME, Sumar.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link SumarResponse }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://servicio.atrium.com/", name = "sumarResponse")
	public JAXBElement<SumarResponse> createSumarResponse(SumarResponse value) {
		return new JAXBElement<SumarResponse>(_SumarResponse_QNAME,
				SumarResponse.class, null, value);
	}

}
