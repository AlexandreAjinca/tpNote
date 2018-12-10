import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

/**
 * The IHM of the business management application
 * @author aajin
 *
 */
@SuppressWarnings("serial")
public class CompanyView extends JFrame implements Observer {
	private Company comp;
	private CompanyControler c;
	
	private JComboBox<Department> departmentList;
	private JComboBox<String> managing;
	private JComboBox<Department> CompanyDepartments;
	private JComboBox<Employee> DepartmentEmployees;
	
	private JButton boutonRecuperation;
	private JButton boutonDepartment;
	private JButton boutonEmployee;
	private JButton deleteDepartment;
	private JButton deleteEmployee;

	private JTextField textFieldDepartment;
	private JTextField textFieldEmployeeLastName;
	private JTextField textFieldEmployeeFirstName;	

	
	/**
	 * The constructor that will initialize the attribute company and the controler
	 * @param comp
	 * The company used by the view
	 */
	public CompanyView(Company comp)  {
		super();
		this.comp = comp;
		c = new CompanyControler(comp);
		setWindow(); 
	}
	
	
	/**
	 * This function set up the window
	 */
	private void setWindow() {
		setTitle("Company gestion");	//On lui donne un titre
		setSize(800,540);	//On lui donne unne taille
		setLocationRelativeTo(null);	//On la positionne au centre
		setResizable(false);	//On interdit le redimensionnement
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Serialization.SerializeCompany(comp);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Arrête le programme si on ferme la fenêtre
		setContentPane(buildPane());
		setVisible(true); //Rend la fenêtre est visible
	}
	
	private JPanel buildPane() {
		JPanel cell1 = new JPanel();
		cell1.setBackground(Color.white);
		String compName = comp.getName();
		JLabel titre = new JLabel(compName);
		Font titleFont = new Font("Arial",Font.BOLD,24);
		titre.setFont(titleFont);
		cell1.add(titre);
		
		JPanel cell2 = new JPanel();
		cell2.setBackground(Color.white);
		boutonRecuperation = new JButton("Recuperate company");
		boutonRecuperation.addActionListener(new RecuperationActionListener());
		cell2.add(boutonRecuperation);
		
		JPanel cell3 = new JPanel();
		cell3.setBackground(Color.white);
		JLabel nomDpt = new JLabel("Department's Name : "); 
		cell3.add(nomDpt);
		
		JPanel cell4 = new JPanel();
		cell4.setBackground(Color.white);
		textFieldDepartment = new JTextField();
		textFieldDepartment.setColumns(10);
		cell4.add(textFieldDepartment);
		
		JPanel cell5 = new JPanel();
		cell5.setBackground(Color.white);
		boutonDepartment = new JButton("Create Department");
		boutonDepartment.addActionListener(new CreationDepartmentListener());
		cell5.add(boutonDepartment);
		
		JPanel cell6 = new JPanel();
		cell6.setBackground(Color.white);
		JLabel prenom = new JLabel("FirstName : ");
		cell6.add(prenom);
		
		JPanel cell7 = new JPanel();
		cell7.setBackground(Color.white);
		textFieldEmployeeLastName = new JTextField();
		textFieldEmployeeLastName.setColumns(10);
		cell7.add(textFieldEmployeeLastName);
		
		JPanel cell8 = new JPanel();
		cell8.setBackground(Color.white);
		JLabel nom = new JLabel("Lastname : "); 
		cell8.add(nom);
		
		JPanel cell9 = new JPanel();
		cell9.setBackground(Color.white);
		textFieldEmployeeFirstName = new JTextField();
		textFieldEmployeeFirstName.setColumns(10);
		cell9.add(textFieldEmployeeFirstName);
		
		JPanel cell10 = new JPanel();
		cell10.setBackground(Color.white);
		JLabel departement = new JLabel("Department :");
		cell10.add(departement);
		
		JPanel cell11 = new JPanel();
		cell11.setBackground(Color.white);
		departmentList = new JComboBox<Department>();
		cell11.add(departmentList);
		
		JPanel cell12 = new JPanel();
		cell12.setBackground(Color.white);
		managing=new JComboBox<String>();
		managing.addItem("Manager");
		managing.addItem("Employee");
		cell12.add(managing);
		
		JPanel cell13 = new JPanel();
		cell13.setBackground(Color.white);
		boutonEmployee = new JButton("Create Employee");
		boutonEmployee.addActionListener(new CreationEmployeeListener());
		cell13.add(boutonEmployee);
		
		JPanel cell14 = new JPanel();
		cell14.setBackground(Color.white);
		JLabel companyDepartment = new JLabel("Departments List");
		cell14.add(companyDepartment);
		
		JPanel cell15 = new JPanel();
		cell15.setBackground(Color.white);
		CompanyDepartments=new JComboBox<Department>();
		CompanyDepartments.addActionListener(new SelectionDepartmentListener());
		cell15.add(CompanyDepartments);
		
		JPanel cell16 = new JPanel();
		cell16.setBackground(Color.white);
		JLabel departmentEmployee = new JLabel("Employee List");
		cell16.add(departmentEmployee);
		
		JPanel cell17 = new JPanel();
		cell17.setBackground(Color.white);
		DepartmentEmployees =new JComboBox<Employee>();
		cell17.add(DepartmentEmployees);
		
		JPanel cell18 = new JPanel();
		cell18.setBackground(Color.white);
		
		JPanel cell19 = new JPanel();
		cell19.setBackground(Color.white);
		deleteDepartment = new JButton("Delete Department");
		deleteDepartment.addActionListener(new DeleteDepartmentListener());
		cell19.add(deleteDepartment);
		
		JPanel cell20 = new JPanel();
		cell20.setBackground(Color.white);
		
		JPanel cell21 = new JPanel();
		cell21.setBackground(Color.white);
		deleteEmployee = new JButton("Delete Employee");
		deleteEmployee.addActionListener(new DeleteEmployeeListener());
		cell21.add(deleteEmployee);
		
		JPanel cell22 = new JPanel();
		cell22.setBackground(Color.white);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setPreferredSize(new Dimension(800,540));
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
	    panel.add(cell1,gbc);
	    
	    gbc.gridx = 3;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    gbc.ipady=10;
	    panel.add(cell2,gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.gridwidth=1;
	    panel.add(cell3,gbc);
	    
	    gbc.gridx = 1;
		panel.add(cell4,gbc);
		
		gbc.gridx = 2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(cell5,gbc);
		
		gbc.gridy=2;
		gbc.gridx=0;
		gbc.gridwidth = 1;
		gbc.weighty = 0;
		gbc.ipady=0;
		panel.add(cell6,gbc);
		
		gbc.gridx=1;
		panel.add(cell7,gbc);
		
		gbc.gridx = 2;
		panel.add(cell8,gbc);
		
		gbc.gridx = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(cell9,gbc);
		
		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.weighty=0.5;
		panel.add(cell10,gbc);
		
		gbc.gridx =1;
		panel.add(cell11,gbc);
		
		gbc.gridx = 2;
		panel.add(cell12,gbc);
		
		gbc.gridx = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(cell13,gbc);
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbc.gridwidth = 1;
		panel.add(cell14,gbc);
		
		gbc.gridx = 1;
		panel.add(cell15,gbc);
		
		gbc.gridx = 2;
		panel.add(cell16,gbc);
		
		gbc.gridx = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(cell17,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth=1;
		panel.add(cell18,gbc);
		
		gbc.gridx = 1;
		panel.add(cell19,gbc);
		
		gbc.gridx = 2;
		panel.add(cell20,gbc);
		
		gbc.gridx = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(cell21,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(cell22,gbc);
		
		return panel;
	}
	
	public JTextField getTextFieldDepartment(){
		return textFieldDepartment;
	}
 
	public JTextField getTextFieldEmployeeLastName(){
		return textFieldEmployeeLastName;
	}
	
	public JTextField getTextFieldEmployeeFirstName() {
		return textFieldEmployeeLastName;
	}
	
	
	class RecuperationActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			comp=Serialization.getCompany();
			if(comp.getCompDpt().size()!=0) {
				for(Department d : comp.getCompDpt()) {
					CompanyDepartments.addItem(d);
					departmentList.addItem(d);
				}
				CompanyDepartments.setSelectedIndex(0);
			}
		}
	}
	
	class CreationDepartmentListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			c.setDptName(textFieldDepartment.getText());
		}
	}

	class CreationEmployeeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			c.setEmployeeName(textFieldEmployeeLastName.getText());
			c.setEmployeeFirstName(textFieldEmployeeFirstName.getText());
			c.setManaging((String)managing.getSelectedItem());
			c.setDep((Department) departmentList.getSelectedItem());
		}
	}
	
	class SelectionDepartmentListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			DepartmentEmployees.removeAllItems();
			if(CompanyDepartments.getItemCount()!=0) {
				for(Employee emp : ((Department) CompanyDepartments.getSelectedItem()).getDptEmployees()){
					DepartmentEmployees.addItem(emp);
				}
			}
		}
	}
	
	class DeleteEmployeeListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			c.setEmployee ((Employee)DepartmentEmployees.getSelectedItem());
		}
		
	}
	
	class DeleteDepartmentListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			c.setDep((Department)CompanyDepartments.getSelectedItem());
		}
		
	}
	
	
	/*
	 * Update the view
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@SuppressWarnings("unused")
	@Override
	public void update(Observable o,Object obj) {
		if(obj.getClass()==Department.class) {
			for(int i = 0;i<departmentList.getItemCount();i++) {
				if((Department)obj == departmentList.getItemAt(i)) {
					CompanyDepartments.setSelectedItem((Department)obj);
					return;
				}
			}
			departmentList.addItem((Department)obj);
			CompanyDepartments.addItem((Department)obj);
		}
		else if(obj.getClass()==Employee.class ||obj.getClass()== Manager.class) {
			CompanyDepartments.setSelectedItem(((Employee)obj).getEmpDpt());
			DepartmentEmployees.setSelectedItem((Employee)obj);
		}
		else if(obj.getClass()==Company.class) {
			this.comp = (Company) obj;
			departmentList.removeAllItems();
			CompanyDepartments.removeAllItems();
			DepartmentEmployees.removeAllItems();
			if(comp.getCompDpt().size()>0) {
				for(Department dep : comp.getCompDpt()) {
					departmentList.addItem(dep);
					CompanyDepartments.addItem(dep);
				}
			}
			if(comp.getCompEmp().size() > 0) {
				for(Employee emp : comp.getCompEmp())
					DepartmentEmployees.addItem(emp);
			}
		}
	}

	
}


