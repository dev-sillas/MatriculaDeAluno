package br.com.exemplo.view;
import br.com.exemplo.model.DadosPessoais;
import br.com.exemplo.model.Notas;
import br.com.exemplo.dao.MVCDao;
import br.com.exemplo.dao.MVCNdao;



import br.com.exemplo.ultil.ConnectionFactory;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;


public class MVC extends JFrame {private JPanel contentPane;
private JMenuBar menuBar;
private JMenu mnNewMenu;
private JMenu mnNewMenu_1;
private JMenu mnNewMenu_2;
private JMenuItem mntmSalvar;
private JMenuItem mntmAlterar;
private JMenuItem mntmExcluir;
private JMenuItem mntmConsultar;
private JMenuItem mntmSair;
private JMenuItem mntmSalvar_1;
private JMenuItem mntmNewMenuItem_4;
private JMenuItem mntmNewMenuItem_5;
private JMenuItem mntmNewMenuItem_6;
private JMenuItem mntmNewMenuItem_7;
private JSeparator separator;
private JTabbedPane tabbedPane;
private JPanel panel;
private JLabel lblNewLabel;
private JLabel lblDataDeNascimento;
private JLabel lblEmail;
private JLabel lblEnd;
private JLabel lblMunicipio;
private JTextField txtRGM;
private JTextField txtNome;
private JLabel lblNome;
private JLabel lblCpf;
private JTextField txtEmail;
private JTextField txtEndereco;
private JTextField txtMunicipio;
private JLabel lblUf;
private JComboBox cmbUF;
private JLabel lblCelular;
private JPanel panel_1;
private JLabel lblCurso;
private JComboBox cmbCurso;
private JComboBox cmbCampus;
private JLabel lblCampus;
private JLabel lblPeriodo;
private JRadioButton rdbtnMatutino;
private JRadioButton rdbtnVespertino;
private JRadioButton rdbtnNoturno;
private JButton btnSair;
private JButton btnExcluir;
private JButton btnConsultar;
private JButton btnAlterar;
private JButton btnSalvar;
private JPanel panel_2;
private JLabel lblRGM1;
private JTextField txtRGM2;
private JLabel lblDisciplina;
private JComboBox cmbDisciplina;
private JLabel lblSemestre;
private JComboBox cmbSemestre;
private JComboBox cmbNota;
private JLabel lblNota;
private JTextField txtFaltas;
private JLabel lblNewLabel_2;
private JButton btnSair2;
private JButton btnCriar;
private JPanel panel_3;
private JFormattedTextField txtData;
private JFormattedTextField txtCpf;
private JLabel lblNewLabel_3;
private JFormattedTextField txtNum;
private JButton btnNovo;
private JLabel lblMensagerNome;
private JLabel lblMensagerCurso;
private DadosPessoais dados;
private MVCDao dao;
private final ButtonGroup btgPeriodo = new ButtonGroup();
private String periodo;
private Notas notas;
private MVCNdao daoN;
private TextArea txtBoletim;
private Button btnListarDados;

/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				MVC frame = new MVC();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

/**
 * Create the frame.
 */
public MVC() throws Exception{
	setTitle("PROGRAMA DO JADIR");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 669, 432);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	menuBar = new JMenuBar();
	menuBar.setBounds(5, 3, 629, 22);
	contentPane.add(menuBar);
	
	mnNewMenu = new JMenu("Alunos");
	menuBar.add(mnNewMenu);
	
	mntmSalvar = new JMenuItem("Salvar");
	mntmSalvar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			salvar();
		}
	});
	mntmSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
	mntmSalvar.setHorizontalAlignment(SwingConstants.LEFT);
	mnNewMenu.add(mntmSalvar);
	
	mntmAlterar = new JMenuItem("Alterar");
	mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterar();
			}
	});
	mntmAlterar.setHorizontalAlignment(SwingConstants.LEFT);
	mnNewMenu.add(mntmAlterar);
	
	mntmConsultar = new JMenuItem("Consultar");
	mntmConsultar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			consultar();
		}
	});
	mntmConsultar.setHorizontalAlignment(SwingConstants.LEFT);
	mnNewMenu.add(mntmConsultar);
	
	mntmExcluir = new JMenuItem("Excluir");
	mntmExcluir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			excluir();
		}
	});
	mntmExcluir.setHorizontalAlignment(SwingConstants.LEFT);
	mnNewMenu.add(mntmExcluir);
	
	separator = new JSeparator();
	mnNewMenu.add(separator);
	
	mntmSair = new JMenuItem("Sair");
	mntmSair.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_MASK));
	mnNewMenu.add(mntmSair);
	
	mnNewMenu_1 = new JMenu("Notas e Faltas");
	menuBar.add(mnNewMenu_1);
	
	mntmSalvar_1 = new JMenuItem("Salvar");
	mntmSalvar_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			salvar();
		}
	});
	mntmSalvar_1.setHorizontalAlignment(SwingConstants.LEFT);
	mnNewMenu_1.add(mntmSalvar_1);
	
	mntmNewMenuItem_4 = new JMenuItem("Alterar");
	mntmNewMenuItem_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			alterar();
		}
	});
	mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
	mntmNewMenuItem_4.setHorizontalAlignment(SwingConstants.LEFT);
	mnNewMenu_1.add(mntmNewMenuItem_4);
	
	mntmNewMenuItem_6 = new JMenuItem("Excluir");
	mntmNewMenuItem_6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			excluir();
		}
	});
	mntmNewMenuItem_6.setHorizontalAlignment(SwingConstants.LEFT);
	mnNewMenu_1.add(mntmNewMenuItem_6);
	
	mntmNewMenuItem_5 = new JMenuItem("Consultar");
	mntmNewMenuItem_5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			consultar();
		}
	});
	mntmNewMenuItem_5.setHorizontalAlignment(SwingConstants.LEFT);
	mnNewMenu_1.add(mntmNewMenuItem_5);
	
	mnNewMenu_2 = new JMenu("Ajuda");
	menuBar.add(mnNewMenu_2);
	
	mntmNewMenuItem_7 = new JMenuItem("Sobre");
	mntmNewMenuItem_7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Programa criado por \nPaulo Werneck RGM:"+ 
																	"\nSillas Torres RGM:"+
															  "\ne Leonardo Oliveira RGM:1723470402");
			//JOptionPane.showMessageDialog(null,"");
		}
	});
	mnNewMenu_2.add(mntmNewMenuItem_7);
	
	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(5, 61, 629, 329);
	contentPane.add(tabbedPane);
	
	panel = new JPanel();
	tabbedPane.addTab("Dados Pessoais", null, panel, null);
	panel.setLayout(null);
	
	lblNewLabel = new JLabel("RGM");
	lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 19));
	lblNewLabel.setBounds(9, 11, 56, 39);
	panel.add(lblNewLabel);
	
	lblDataDeNascimento = new JLabel("Data de Nascimento");
	lblDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 19));
	lblDataDeNascimento.setBounds(10, 72, 178, 39);
	panel.add(lblDataDeNascimento);
	
	lblEmail = new JLabel("Email");
	lblEmail.setFont(new Font("Arial", Font.PLAIN, 19));
	lblEmail.setBounds(11, 128, 56, 39);
	panel.add(lblEmail);
	
	lblEnd = new JLabel("Endereço");
	lblEnd.setFont(new Font("Arial", Font.PLAIN, 19));
	lblEnd.setBounds(10, 189, 56, 39);
	panel.add(lblEnd);
	
	lblMunicipio = new JLabel("Municipio");
	lblMunicipio.setFont(new Font("Arial", Font.PLAIN, 19));
	lblMunicipio.setBounds(9, 248, 86, 39);
	panel.add(lblMunicipio);
	
	txtRGM = new JTextField();
	txtRGM.setFont(new Font("Tahoma", Font.PLAIN, 16));
	txtRGM.setBounds(74, 11, 128, 39);
	panel.add(txtRGM);
	txtRGM.setColumns(10);
	
	txtNome = new JTextField();
	txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
	txtNome.setColumns(10);
	txtNome.setBounds(277, 11, 324, 39);
	panel.add(txtNome);
	
	lblNome = new JLabel("Nome");
	lblNome.setFont(new Font("Arial", Font.PLAIN, 19));
	lblNome.setBounds(212, 11, 56, 39);
	panel.add(lblNome);
	
	lblCpf = new JLabel("CPF");
	lblCpf.setFont(new Font("Arial", Font.PLAIN, 19));
	lblCpf.setBounds(343, 72, 41, 39);
	panel.add(lblCpf);
	
	txtEmail = new JTextField();
	txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
	txtEmail.setColumns(10);
	txtEmail.setBounds(64, 129, 537, 39);
	panel.add(txtEmail);
	
	txtEndereco = new JTextField();
	txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 16));
	txtEndereco.setColumns(10);
	txtEndereco.setBounds(64, 189, 537, 39);
	panel.add(txtEndereco);
	
	txtMunicipio = new JTextField();
	txtMunicipio.setFont(new Font("Tahoma", Font.PLAIN, 16));
	txtMunicipio.setColumns(10);
	txtMunicipio.setBounds(95, 248, 128, 39);
	panel.add(txtMunicipio);
	
	lblUf = new JLabel("UF");
	lblUf.setFont(new Font("Arial", Font.PLAIN, 19));
	lblUf.setBounds(233, 248, 31, 39);
	panel.add(lblUf);
	
	cmbUF = new JComboBox();
	cmbUF.setFont(new Font("Tahoma", Font.PLAIN, 16));
	cmbUF.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
	cmbUF.setBounds(266, 253, 46, 34);
	panel.add(cmbUF);
	
	lblCelular = new JLabel("Celular");
	lblCelular.setFont(new Font("Arial", Font.PLAIN, 19));
	lblCelular.setBounds(338, 248, 66, 39);
	panel.add(lblCelular);
	
	txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
	txtData.setFont(new Font("Arial", Font.PLAIN, 18));
	txtData.setBounds(198, 73, 146, 39);
	panel.add(txtData);
	
	txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
	txtCpf.setFont(new Font("Arial", Font.PLAIN, 18));
	txtCpf.setBounds(390, 72, 211, 39);
	panel.add(txtCpf);
	
	txtNum = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
	txtNum.setFont(new Font("Arial", Font.PLAIN, 18));
	txtNum.setBounds(403, 248, 200, 39);
	panel.add(txtNum);
	
	panel_1 = new JPanel();
	tabbedPane.addTab("Curso", null, panel_1, null);
	panel_1.setLayout(null);
	
	lblCurso = new JLabel("Curso");
	lblCurso.setFont(new Font("Arial", Font.PLAIN, 19));
	lblCurso.setBounds(10, 21, 56, 39);
	panel_1.add(lblCurso);
	
	cmbCurso = new JComboBox();
	cmbCurso.setFont(new Font("Tahoma", Font.PLAIN, 16));
	cmbCurso.setModel(new DefaultComboBoxModel(new String[] {"An\u00E1lise de Desenvolvimento de Sistemas", "Ci\u00EAncias da Computa\u00E7\u00E3o", "Banco de dados", "Ci\u00EAncia de dados", "Ci\u00EAncias Cont\u00E1beis", "Ci\u00EAncias Econ\u00F4micas", "Engenharia Ambiental", "Engenharia Civil", "Engenharia da Computa\u00E7\u00E3o", "Engenharia de Produ\u00E7\u00E3o", "Engenharia de Software", "Engenharia El\u00E9trica", "Engenharia Mec\u00E2nica", "Engenharia Mecatr\u00F4nica", "F\u00EDsica", "Gest\u00E3o Comercial", "Gest\u00E3o de Produ\u00E7\u00E3o Industrial", "Gest\u00E3o de Tecnologia da Informa\u00E7\u00E3o", "Gest\u00E3o Cooperativas", "Gest\u00E3o de Seguran\u00E7a Privada", "Gest\u00E3o Financeira", "Marketing Digital", "Matem\u00E1tica", "Qu\u00EDmica", "Redes de Computadores", "Sistemas de Informa\u00E7\u00E3o", "Sistemas Para Internet"}));
	cmbCurso.setBounds(86, 21, 515, 39);
	panel_1.add(cmbCurso);
	
	cmbCampus = new JComboBox();
	cmbCampus.setFont(new Font("Tahoma", Font.PLAIN, 16));
	cmbCampus.setModel(new DefaultComboBoxModel(new String[] {"Unicid Tatuap\u00E9", "Unicid Pinheiros"}));
	cmbCampus.setBounds(86, 85, 515, 39);
	panel_1.add(cmbCampus);
	
	lblCampus = new JLabel("Campus");
	lblCampus.setFont(new Font("Arial", Font.PLAIN, 19));
	lblCampus.setBounds(10, 85, 88, 39);
	panel_1.add(lblCampus);
	
	lblPeriodo = new JLabel("Per\u00EDodo");
	lblPeriodo.setFont(new Font("Arial", Font.PLAIN, 19));
	lblPeriodo.setBounds(10, 147, 88, 39);
	panel_1.add(lblPeriodo);
	
	rdbtnMatutino = new JRadioButton("Matutino");
	rdbtnMatutino.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(rdbtnMatutino.isSelected()) {
				rdbtnVespertino.setSelected(false);
				rdbtnNoturno.setSelected(false);
			}
		}
	});
	//rdbtnMatutino.setSelected(true);
	btgPeriodo.add(rdbtnMatutino);
	rdbtnMatutino.setFont(new Font("Arial", Font.PLAIN, 19));
	rdbtnMatutino.setBounds(104, 155, 109, 23);
	panel_1.add(rdbtnMatutino);
	
	rdbtnVespertino = new JRadioButton("Vespertino");
	rdbtnVespertino.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(rdbtnVespertino.isSelected()) {
				rdbtnMatutino.setSelected(false);
				rdbtnNoturno.setSelected(false);
			}
		}
	});
	btgPeriodo.add(rdbtnVespertino);
	rdbtnVespertino.setFont(new Font("Arial", Font.PLAIN, 19));
	rdbtnVespertino.setBounds(236, 155, 122, 23);
	panel_1.add(rdbtnVespertino);
	
	rdbtnNoturno = new JRadioButton("Noturno");
	rdbtnNoturno.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(rdbtnNoturno.isSelected()) {}
			rdbtnMatutino.setSelected(false);
			rdbtnVespertino.setSelected(false);
		}
	});
	btgPeriodo.add(rdbtnNoturno);
	rdbtnNoturno.setFont(new Font("Arial", Font.PLAIN, 19));
	rdbtnNoturno.setBounds(385, 155, 109, 23);
	panel_1.add(rdbtnNoturno);
	
	btnSair = new JButton("Sair");
	btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnSair.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	btnSair.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Eclipse-img\\off.png"));
	btnSair.setBounds(20, 202, 76, 66);
	panel_1.add(btnSair);
	
	btnExcluir = new JButton("Excluir");
	btnExcluir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		excluir();
		}
	});
	btnExcluir.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Eclipse-img\\past.png"));
	btnExcluir.setBounds(116, 202, 81, 66);
	panel_1.add(btnExcluir);
	
	btnConsultar = new JButton("Consultar");
	btnConsultar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			consultar();
		}
	});
	btnConsultar.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Eclipse-img\\Sem T\u00EDtulo-1.png"));
	btnConsultar.setBounds(221, 202, 86, 66);
	panel_1.add(btnConsultar);
	
	btnAlterar = new JButton("Alterar");
	btnAlterar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			alterar();
		}
	});
	btnAlterar.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Eclipse-img\\Sem T\u00EDtulo2.png"));
	btnAlterar.setBounds(330, 202, 81, 66);
	panel_1.add(btnAlterar);
	
	btnSalvar = new JButton("Salvar");
	btnSalvar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			salvar();
		}
	});
	btnSalvar.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Eclipse-img\\Sem T\u00EDtulo-3.png"));
	btnSalvar.setBounds(448, 202, 89, 66);
	panel_1.add(btnSalvar);
	
	panel_2 = new JPanel();
	tabbedPane.addTab("Notas e Faltas", null, panel_2, null);
	panel_2.setLayout(null);
	
	lblRGM1 = new JLabel("RGM");
	lblRGM1.setFont(new Font("Arial", Font.PLAIN, 19));
	lblRGM1.setBounds(9, 6, 56, 39);
	panel_2.add(lblRGM1);
	
	txtRGM2 = new JTextField();
	txtRGM2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			consultar();
		}
	});
	txtRGM2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	txtRGM2.setColumns(10);
	txtRGM2.setBounds(75, 11, 166, 31);
	panel_2.add(txtRGM2);
	
	lblDisciplina = new JLabel("Disciplina");
	lblDisciplina.setFont(new Font("Arial", Font.PLAIN, 19));
	lblDisciplina.setBounds(8, 97, 96, 39);
	panel_2.add(lblDisciplina);
	
	cmbDisciplina = new JComboBox();
	cmbDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 16));
	cmbDisciplina.setModel(new DefaultComboBoxModel(new String[] {"Programa\u00E7\u00E3o Orientada a Objetos", "Modelagem de Dados", "Redes de Computadores", "Matem\u00E1tica Discreta", "Estrutura de Dados I", "Calculo Diferencial e Integral II"}));
	cmbDisciplina.setBounds(114, 98, 500, 39);
	panel_2.add(cmbDisciplina);
	
	lblSemestre = new JLabel("Semestre");
	lblSemestre.setFont(new Font("Arial", Font.PLAIN, 19));
	lblSemestre.setBounds(10, 158, 96, 39);
	panel_2.add(lblSemestre);
	
	cmbSemestre = new JComboBox();
	cmbSemestre.setFont(new Font("Tahoma", Font.PLAIN, 16));
	cmbSemestre.setModel(new DefaultComboBoxModel(new String[] {"2020-1", "2020-2", "2021-1", "2021-2"}));
	cmbSemestre.setBounds(101, 159, 96, 39);
	panel_2.add(cmbSemestre);
	
	cmbNota = new JComboBox();
	cmbNota.setFont(new Font("Tahoma", Font.PLAIN, 16));
	cmbNota.setModel(new DefaultComboBoxModel(new String[] {"0.5", "1.0", "1.5", "2.0", "2.5", "3.0", "3.5", "4.0", "4.5", "5.0", "5.5", "6.0", "6.5", "7.0", "7.5", "8.0", "8.5", "9.0", "9.5", "10.0"}));
	cmbNota.setBounds(297, 159, 56, 39);
	panel_2.add(cmbNota);
	
	lblNota = new JLabel("Nota");
	lblNota.setFont(new Font("Arial", Font.PLAIN, 19));
	lblNota.setBounds(231, 158, 56, 39);
	panel_2.add(lblNota);
	
	txtFaltas = new JTextField();
	txtFaltas.setFont(new Font("Tahoma", Font.PLAIN, 16));
	txtFaltas.setColumns(10);
	txtFaltas.setBounds(471, 159, 118, 39);
	panel_2.add(txtFaltas);
	
	lblNewLabel_2 = new JLabel("Faltas");
	lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 19));
	lblNewLabel_2.setBounds(406, 158, 55, 39);
	panel_2.add(lblNewLabel_2);
	
	btnSair2 = new JButton("Sair");
	btnSair2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnSair2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	btnSair2.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Eclipse-img\\off.png"));
	btnSair2.setBounds(458, 224, 81, 66);
	panel_2.add(btnSair2);
	
	btnCriar = new JButton("Criar");
	btnCriar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			salvar();
		}
	});
	btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnCriar.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Eclipse-img\\Sem T\u00EDtulo-3.png"));
	btnCriar.setBounds(346, 226, 86, 64);
	panel_2.add(btnCriar);
	
	lblMensagerNome = new JLabel("sillas torres santos");
	lblMensagerNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblMensagerNome.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.BLACK));
	lblMensagerNome.setBounds(251, 11, 350, 31);
	panel_2.add(lblMensagerNome);
	
	lblMensagerCurso = new JLabel("Ci\u00EAncia de dados");
	lblMensagerCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblMensagerCurso.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.BLACK));
	lblMensagerCurso.setBounds(20, 56, 581, 31);
	panel_2.add(lblMensagerCurso);
	
	panel_3 = new JPanel();
	tabbedPane.addTab("Boletim", null, panel_3, null);
	panel_3.setLayout(null);
	
	btnListarDados = new Button("Listar");
	btnListarDados.setFont(new Font("Dialog", Font.PLAIN, 18));
	btnListarDados.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Listar();
		}
	});
	txtBoletim = new TextArea();
	txtBoletim.setText("sillas torres santos\r\n2.0\r\nmodelagem de dados\r\n2020-01\r\n2 faltas");
	txtBoletim.setFont(new Font("Tahoma", Font.PLAIN, 16));
	txtBoletim.setBounds(10, 74, 604, 217);
	panel_3.add(txtBoletim);
	
	
	btnListarDados.setBounds(176, 24, 142, 29);
	panel_3.add(btnListarDados);
	
	lblNewLabel_3 = new JLabel("ScriptHit");
	lblNewLabel_3.setForeground(new Color(204, 204, 204));
	lblNewLabel_3.setFont(new Font("Evogria", Font.ITALIC, 26));
	lblNewLabel_3.setBounds(521, 31, 128, 42);
	contentPane.add(lblNewLabel_3);
	
	btnNovo = new JButton("Limpar");
	btnNovo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		limpar();
			
		}
	});
	btnNovo.setBounds(415, 34, 96, 23);
	contentPane.add(btnNovo);
}
	public void salvar() {
		//como faço para colocar no codigo?
		DadosPessoais dados=new DadosPessoais();
		Notas notas=new Notas();
		dados.setCampus((String)cmbCampus.getSelectedItem());
		dados.setCel(txtNum.getText());//cel
		dados.setCpf(txtCpf.getText());//cpf
		dados.setCurso((String)cmbCurso.getSelectedItem());
		dados.setDataNasc(txtData.getText());
		dados.setEmail(txtEmail.getText());
		dados.setEndereco(txtEndereco.getText());
		dados.setMinicipio(txtMunicipio.getText());
		dados.setNome(txtNome.getText());
		dados.setRgm(Integer.parseInt(txtRGM.getText()));
		dados.setUf((String)cmbUF.getSelectedItem());
		
		if(rdbtnMatutino.isSelected()) {
			dados.setPeriodo("Matutino");
		}
		else if(rdbtnVespertino.isSelected()) {
			dados.setPeriodo("Vespertino");
		} else {
			dados.setPeriodo("Noturno");
		}
		notas.setRgm(Integer.parseInt(txtRGM.getText()));
		notas.setDisciplina((String)cmbDisciplina.getSelectedItem());
		notas.setSemestre((String)cmbSemestre.getSelectedItem());
		notas.setNota((String)cmbNota.getSelectedItem());
		notas.setFaltas(txtFaltas.getText());
		try{//abre o banco de dados
		MVCDao dao= new MVCDao();
		MVCNdao daoN=new MVCNdao();
		//salvar 
		dao.salvar(dados);
		daoN.salvar(notas);//atualizar
		JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null,"Erro ao salvar!"+e.getMessage());
	}
}
	public void excluir() {
		try {daoN=new MVCNdao();
			dao=new MVCDao();
			
			int codigo=Integer.parseInt(txtRGM.getText());
			daoN.deletar(codigo);
			dao.excluir(codigo);
			
			JOptionPane.showMessageDialog(null,"Excluido com sucesso!");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Erro ao excluir!"+e.getMessage());
		}
	}
	public void limpar() {
		txtRGM.setText(null);
		txtNome.setText(null);
		txtData.setText(null);
		txtCpf.setText(null);
		txtEmail.setText(null);
		txtEndereco.setText(null);
		txtMunicipio.setText(null);
		cmbUF.setSelectedIndex(0);
		txtNum.setText(null);
		cmbCampus.setSelectedIndex(0);
		cmbCurso.setSelectedIndex(0);
		rdbtnMatutino.setSelected(true);
		cmbNota.setSelectedIndex(0);
		cmbDisciplina.setSelectedIndex(0);
		txtRGM2.setText(null);
		cmbDisciplina.setSelectedIndex(0);
		cmbSemestre.setSelectedIndex(0);
		cmbNota.setSelectedIndex(0);
		txtFaltas.setText(null);
		txtBoletim.setText("");
	}
		public void alterar() {
		try {
			dados=new DadosPessoais();
			notas=new Notas();
			dados.setCampus((String)cmbCampus.getSelectedItem());
			dados.setCel(txtNum.getText());
			dados.setCpf(txtCpf.getText());				
			dados.setCurso((String)cmbCurso.getSelectedItem());
			dados.setDataNasc(txtData.getText());
			dados.setEmail(txtEmail.getText());
			dados.setEndereco(txtEndereco.getText());
			dados.setMinicipio(txtMunicipio.getText());
			dados.setNome(txtNome.getText());
			dados.setRgm(Integer.parseInt(txtRGM.getText()));
			dados.setUf((String)cmbUF.getSelectedItem());
			
			if(rdbtnMatutino.isSelected()) {
				dados.setPeriodo("Matutino");
			}
			else if(rdbtnVespertino.isSelected()) {
				dados.setPeriodo("Vespertino");
			} else if(rdbtnNoturno.isSelected()){
				dados.setPeriodo("Noturno");
			}
			notas.setDisciplina((String)cmbDisciplina.getSelectedItem());
			notas.setFaltas(txtFaltas.getText());
			notas.setNota((String)cmbNota.getSelectedItem());
			notas.setSemestre((String)cmbSemestre.getSelectedItem());
			notas.setRgm(Integer.parseInt(txtRGM.getText()));
			
			dao=new MVCDao();
			dao.alterar(dados);
			
			daoN=new MVCNdao();
			daoN.alterar(notas);
			
			JOptionPane.showMessageDialog(null,"Atualização com sucesso!");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Erro ao atualizar os dados!"+ e.getMessage());
		}
	}
	
	public void consultar() {
		try {
		dao= new MVCDao();
		daoN=new MVCNdao();
		int codigo=Integer.parseInt(txtRGM.getText());
		dados=dao.consultar(codigo);
		cmbCampus.setSelectedItem((String)dados.getCampus());
		txtNum.setText(dados.getCel());
		txtCpf.setText(dados.getCpf());
		cmbCurso.setSelectedItem((String)dados.getCurso());
		txtData.setText(dados.getDataNasc());
		txtEmail.setText(dados.getEmail());
		txtEndereco.setText(dados.getEndereco());
		dados.getId();
		txtMunicipio.setText(dados.getMinicipio());
		txtNome.setText(dados.getNome());
		
		String periodo=dados.getPeriodo();
		
		if(periodo.equals("Matutino")){
			rdbtnMatutino.setSelected(true);
		}else if(periodo.equals("Vespertino")) {
			rdbtnVespertino.setSelected(true);
		}else if(periodo.equals("Noturno")) {
			rdbtnNoturno.setSelected(true);
		}
		
		cmbUF.setSelectedItem((String)dados.getUf());
		
		notas=daoN.consultar(codigo);
		txtRGM2.setText(Integer.toString(dados.getRgm()));
		cmbDisciplina.setSelectedItem((String)notas.getDisciplina());
		cmbSemestre.setSelectedItem((String)notas.getSemestre());
		cmbNota.setSelectedItem((String)notas.getNota());
		txtFaltas.setText(notas.getFaltas());
		lblMensagerCurso.setText(dados.getCurso());
		lblMensagerNome.setText(dados.getNome());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Erro ao consultar"+e.getMessage());
		}
	}
	public void Listar() {
		try {	
				List<DadosPessoais>lista=new ArrayList<DadosPessoais>();
				List<Notas>listaN=new ArrayList<Notas>();
				dao=new MVCDao();
				daoN=new MVCNdao();
				lista=dao.DadosPessoaistodos();
				listaN=daoN.todos();
				for(Notas notas:listaN) { 
				for(DadosPessoais dados:lista){
					txtBoletim.append("\nRgm do Aluno:"+dados.getRgm()+"\n");
					txtBoletim.append("Nome do Aluno:"+dados.getNome()+"\n");
					txtBoletim.append("Curso do Aluno:"+dados.getCurso()+"\n");
					txtBoletim.append("\nDisciplina do Aluno:"+notas.getDisciplina()+"\n");
					txtBoletim.append("Nota do Aluno:"+notas.getNota()+"\n");
					txtBoletim.append("Faltas do Aluno:"+notas.getFaltas()+"\n");
					txtBoletim.append("\n\n");
					}
				}
				
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Erro ao listar os dados!"+e.getMessage());
		}
	}
}
