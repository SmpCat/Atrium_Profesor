package com.atrium.controlador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import com.atrium.modelo.Modelo_Calculadora;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Rectangle;

public class Ventana extends JFrame implements ActionListener {
	// PROPIEDADES DE CLASE
	// ***** PANEL DEL VISOR
	private JPanel panel_visor;
	private JLabel visor;
	private JPanel panel_botones;
	private JButton boton_1;
	private JButton boton_3;
	private JButton boton_4;
	private JButton boton_2;
	private JButton boton_6;
	private JButton boton_7;
	private JButton boton_5;
	private JButton boton_9;
	private JButton boton_8;
	private JButton boton_0;
	private JPanel panel_operaciones;
	private JButton boton_sumar;
	private JButton boton_multiplicar;
	private JButton boton_restar;
	private JButton boton_division;

	// MODELO DE LA APLICACION
	private Modelo_Calculadora modelo;
	// PROPIEDADES PARA EL PROCESO
	private boolean operacion = false;
	private char ultima_operacion;
	private JButton boton_ce;
	private JButton boton_igual;

	public Ventana() {
		// CREACION DEL DTO
		modelo = new Modelo_Calculadora();
		// AJUSTES DE LA VENTANA
		setBounds(new Rectangle(250, 125, 400, 500));
		getContentPane().setLayout(null);
		// LLAMADA A LA CREACION DEL CONTENIDO DE LA VISTA
		crear_Interface();

		setVisible(true);
	}

	public void crear_Interface() {
		panel_visor = new JPanel();
		panel_visor.setBounds(0, 0, 384, 57);
		getContentPane().add(panel_visor);
		panel_visor.setLayout(null);

		visor = new JLabel("0");
		visor.setOpaque(true);
		visor.setBackground(new Color(169, 169, 169));
		visor.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		visor.setHorizontalAlignment(SwingConstants.RIGHT);
		visor.setFont(new Font("Times New Roman", Font.BOLD, 35));
		visor.setBounds(6, 6, 372, 45);
		panel_visor.add(visor);

		panel_botones = new JPanel();
		panel_botones.setBounds(0, 56, 241, 400);
		getContentPane().add(panel_botones);
		panel_botones.setLayout(new GridLayout(0, 3, 1, 1));

		boton_1 = new JButton("1");
		boton_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel_botones.add(boton_1);

		boton_2 = new JButton("2");
		boton_2.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel_botones.add(boton_2);

		boton_3 = new JButton("3");
		boton_3.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel_botones.add(boton_3);

		boton_4 = new JButton("4");
		boton_4.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel_botones.add(boton_4);

		boton_5 = new JButton("5");
		boton_5.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel_botones.add(boton_5);

		boton_6 = new JButton("6");
		boton_6.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel_botones.add(boton_6);

		boton_7 = new JButton("7");
		boton_7.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel_botones.add(boton_7);

		boton_8 = new JButton("8");
		boton_8.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel_botones.add(boton_8);

		boton_9 = new JButton("9");
		boton_9.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel_botones.add(boton_9);

		boton_ce = new JButton("CE");
		boton_ce.setBackground(new Color(255, 0, 0));
		boton_ce.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel_botones.add(boton_ce);

		boton_0 = new JButton("0");
		boton_0.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel_botones.add(boton_0);

		boton_igual = new JButton("=");
		boton_igual.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_botones.add(boton_igual);

		panel_operaciones = new JPanel();
		panel_operaciones.setBounds(245, 56, 139, 400);
		getContentPane().add(panel_operaciones);
		panel_operaciones.setLayout(new GridLayout(0, 2, 1, 1));

		boton_sumar = new JButton("+");
		boton_sumar.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_operaciones.add(boton_sumar);

		boton_restar = new JButton("-");
		boton_restar.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_operaciones.add(boton_restar);

		boton_multiplicar = new JButton("*");
		boton_multiplicar.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_operaciones.add(boton_multiplicar);

		boton_division = new JButton("/");
		boton_division.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_operaciones.add(boton_division);

		// ASOCIAMOS LOS COMPONENTES AL ESCUCHADOR
		boton_0.addActionListener(this);
		boton_1.addActionListener(this);
		boton_2.addActionListener(this);
		boton_3.addActionListener(this);
		boton_4.addActionListener(this);
		boton_5.addActionListener(this);
		boton_6.addActionListener(this);
		boton_7.addActionListener(this);
		boton_8.addActionListener(this);
		boton_9.addActionListener(this);
		boton_sumar.addActionListener(this);
		boton_restar.addActionListener(this);
		boton_multiplicar.addActionListener(this);
		boton_division.addActionListener(this);
		boton_igual.addActionListener(this);
		boton_ce.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// CONOCIMIENTO DE BOTON SELECCIONADO
		String boton_seleccionado = ((JButton) evento.getSource()).getText();
		// ELIMINACION DEL CERO INICIAL
		if (visor.getText().equals("0")) {
			visor.setText("");
		}
		// TRATAMIENTO DEL NUEVO NUMERO
		if (operacion) {
			// QUITAMOS EL NUMERO ANTERIOR
			visor.setText("");
			operacion = false;
		}
		// PONER EL NUMERO TECLEADO EN LA ETIQUETA
		if (boton_seleccionado.equals("1")) {
			visor.setText(visor.getText() + "1");
		}
		if (boton_seleccionado.equals("2")) {
			visor.setText(visor.getText() + "2");
		}
		if (boton_seleccionado.equals("3")) {
			visor.setText(visor.getText() + "3");
		}
		if (boton_seleccionado.equals("4")) {
			visor.setText(visor.getText() + "4");
		}
		if (boton_seleccionado.equals("5")) {
			visor.setText(visor.getText() + "5");
		}
		if (boton_seleccionado.equals("6")) {
			visor.setText(visor.getText() + "6");
		}
		if (boton_seleccionado.equals("7")) {
			visor.setText(visor.getText() + "7");
		}
		if (boton_seleccionado.equals("8")) {
			visor.setText(visor.getText() + "8");
		}
		if (boton_seleccionado.equals("9")) {
			visor.setText(visor.getText() + "9");
		}
		if (boton_seleccionado.equals("0")) {
			visor.setText(visor.getText() + "0");
		}
		// OPERACIONES ARITMETICAS
		if (boton_seleccionado.equals("+")) {
			if (modelo.getOpe_1() == 0) {
				// PRIMER NUMERO TECLEADO
				modelo.setOpe_1(Integer.parseInt(visor.getText()));
			} else {
				if (!visor.getText().equals("")) {
					// SEGUN Y SIGUIENTES NUMEROS
					modelo.setOpe_2(Integer.parseInt(visor.getText()));
					// SUMA DE LOS NUMEROS
					modelo.setResultado(modelo.getOpe_1() + modelo.getOpe_2());
					// VISUALIZACION DEL RESULTADO DE LA SUMA
					visor.setText(String.valueOf(modelo.getResultado()));
					// ESTABLECEMOS COMO NUEVO OPERADOR UNO EL RESULTADO PARCIAL
					modelo.setOpe_1(modelo.getResultado());
				}
			}
			// MOVIMIENTO DE BANDERA PARA LA LOGICA DE LA OPERACION
			operacion = true;
			ultima_operacion = '+';
		}
		if (boton_seleccionado.equals("-")) {
			if (modelo.getOpe_1() == 0) {
				// PRIMER NUMERO TECLEADO
				modelo.setOpe_1(Integer.parseInt(visor.getText()));
			} else {
				if (!visor.getText().equals("")) {
					// SEGUN Y SIGUIENTES NUMEROS
					modelo.setOpe_2(Integer.parseInt(visor.getText()));
					// SUMA DE LOS NUMEROS
					modelo.setResultado(modelo.getOpe_1() - modelo.getOpe_2());
					// VISUALIZACION DEL RESULTADO DE LA SUMA
					visor.setText(String.valueOf(modelo.getResultado()));
					// ESTABLECEMOS COM NUEVO OPERADOR UNO EL RESULTADO PARCIAL
					modelo.setOpe_1(modelo.getResultado());
				}
			}
			// MOVIMIENTO DE BANDERA PARA LA LOGICA DE LA OPERACION
			operacion = true;
			ultima_operacion = '-';
		}
		if (boton_seleccionado.equals("*")) {
			if (modelo.getOpe_1() == 0) {
				// PRIMER NUMERO TECLEADO
				modelo.setOpe_1(Integer.parseInt(visor.getText()));
			} else {
				if (!visor.getText().equals("")) {
					// SEGUN Y SIGUIENTES NUMEROS
					modelo.setOpe_2(Integer.parseInt(visor.getText()));
					// SUMA DE LOS NUMEROS
					modelo.setResultado(modelo.getOpe_1() * modelo.getOpe_2());
					// VISUALIZACION DEL RESULTADO DE LA SUMA
					visor.setText(String.valueOf(modelo.getResultado()));
					// ESTABLECEMOS COM NUEVO OPERADOR UNO EL RESULTADO PARCIAL
					modelo.setOpe_1(modelo.getResultado());
				}
			}
			// MOVIMIENTO DE BANDERA PARA LA LOGICA DE LA OPERACION
			operacion = true;
			ultima_operacion = '*';
		}
		if (boton_seleccionado.equals("/")) {
			if (modelo.getOpe_1() == 0) {
				// PRIMER NUMERO TECLEADO
				modelo.setOpe_1(Integer.parseInt(visor.getText()));
			} else {
				if (!visor.getText().equals("")) {
					// SEGUN Y SIGUIENTES NUMEROS
					modelo.setOpe_2(Integer.parseInt(visor.getText()));
					// SUMA DE LOS NUMEROS
					modelo.setResultado(modelo.getOpe_1() / modelo.getOpe_2());
					// VISUALIZACION DEL RESULTADO DE LA SUMA
					visor.setText(String.valueOf(modelo.getResultado()));
					// ESTABLECEMOS COM NUEVO OPERADOR UNO EL RESULTADO PARCIAL
					modelo.setOpe_1(modelo.getResultado());
				}
			}
			// MOVIMIENTO DE BANDERA PARA LA LOGICA DE LA OPERACION
			operacion = true;
			ultima_operacion = '/';
		}
		// CERRAMOS LA OPERACION AL PULSAR IGUAL
		if (boton_seleccionado.equals("=")) {
			switch (ultima_operacion) {
			case '+':
				visor.setText(String.valueOf(modelo.getOpe_1() + Integer.parseInt(visor.getText())));
				break;
			case '-':
				visor.setText(String.valueOf(modelo.getOpe_1() - Integer.parseInt(visor.getText())));
				break;
			case '*':
				visor.setText(String.valueOf(modelo.getOpe_1() * Integer.parseInt(visor.getText())));
				break;
			case '/':
				visor.setText(String.valueOf(modelo.getOpe_1() / Integer.parseInt(visor.getText())));
				break;
			}
			ultima_operacion = ' ';
			modelo.setOpe_1(0);
			modelo.setOpe_2(0);
			modelo.setResultado(0);
			operacion = true;
		}
		// BORRAMOS LA PANTALLA E INICIAMOS
		if (boton_seleccionado.equals("CE")) {
			visor.setText("0");
			ultima_operacion = ' ';
			modelo.setOpe_1(0);
			modelo.setOpe_2(0);
			modelo.setResultado(0);
			operacion = false;
		}
	}
}
