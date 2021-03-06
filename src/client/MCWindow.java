package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class MCWindow extends JFrame {

	private JPanel contentPane;
	private OrderWindow OwO = null;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MCWindow frame = new MCWindow();
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
	public MCWindow() {
		JList<String> itemlist = new JList<String>();
		DefaultListModel<String> itemmodel=new DefaultListModel<String>();
		List<String> viewstring=new ArrayList<String>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{182, 197, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		JTextPane itemview = new JTextPane();
		itemview.setEditable(false);
		JButton initbtn = new JButton("Starting Order");
		initbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OwO==null) {
					OwO = new OrderWindow();
					OwO.setMC();
					itemmodel.clear();
					for(String str:OwO.ma.getAllstock()) {
						itemmodel.addElement(str);
					}
					itemlist.setModel(itemmodel);
					viewstring.clear();
				}
			}
		});
		
		JButton addbtn = new JButton("Add Dish");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = itemlist.getSelectedIndex();
				String[] item = itemmodel.getElementAt(sel).split(":");
				String add = itemmodel.getElementAt(sel);
				Double num = Double.parseDouble(textField.getText());
				add = item[0]+":"+(Double.parseDouble(item[1])-num)+item[2];
				itemmodel.removeElementAt(sel);
				itemmodel.insertElementAt(add, sel);
				itemlist.setModel(itemmodel);
				viewstring.add(item[0]+":"+num+":"+item[2]);
				textField.setText("");
				String tmp="";
				for(String str:viewstring)
					tmp+=str+'\n';
				itemview.setText(tmp);
			}
		});
		
		JScrollPane itemscroll = new JScrollPane();
		GridBagConstraints gbc_itemscroll = new GridBagConstraints();
		gbc_itemscroll.gridheight = 5;
		gbc_itemscroll.insets = new Insets(0, 0, 0, 5);
		gbc_itemscroll.fill = GridBagConstraints.BOTH;
		gbc_itemscroll.gridx = 1;
		gbc_itemscroll.gridy = 0;
		contentPane.add(itemscroll, gbc_itemscroll);
		
		itemscroll.setViewportView(itemlist);
		GridBagConstraints gbc_addbtn = new GridBagConstraints();
		gbc_addbtn.insets = new Insets(0, 0, 5, 0);
		gbc_addbtn.gridx = 2;
		gbc_addbtn.gridy = 0;
		contentPane.add(addbtn, gbc_addbtn);
		

		GridBagConstraints gbc_itemview = new GridBagConstraints();
		gbc_itemview.gridheight = 5;
		gbc_itemview.insets = new Insets(0, 0, 0, 5);
		gbc_itemview.fill = GridBagConstraints.BOTH;
		gbc_itemview.gridx = 0;
		gbc_itemview.gridy = 0;
		contentPane.add(itemview, gbc_itemview);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		GridBagConstraints gbc_initbtn = new GridBagConstraints();
		gbc_initbtn.insets = new Insets(0, 0, 5, 0);
		gbc_initbtn.gridx = 2;
		gbc_initbtn.gridy = 2;
		contentPane.add(initbtn, gbc_initbtn);
		
		JButton refresh = new JButton("ReFresh List");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Refreshlist(itemmodel);
				textField.setText("");
				itemview.setText("");
			}
		});
		
		JButton checkoutbtn = new JButton("Check out");
		checkoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(OwO == null)
					return;
				String[] codata=itemview.getText().split("\n");
				double num,price,total;
				String[] data;
				total = 0;
				for(String in:codata) {
					data=in.split(":");
					num = Double.parseDouble(data[1]);
					price = Double.parseDouble(data[2]);
					OwO.ma.findItem(data[0]).removeitem(num);
					total+= num * price; 
				}
				JOptionPane.showMessageDialog(null,"結帳成功，總共"+total+"元");
				Refreshlist(itemmodel);
				itemview.setText("");
			}
		});
		GridBagConstraints gbc_checkoutbtn = new GridBagConstraints();
		gbc_checkoutbtn.insets = new Insets(0, 0, 5, 0);
		gbc_checkoutbtn.gridx = 2;
		gbc_checkoutbtn.gridy = 3;
		contentPane.add(checkoutbtn, gbc_checkoutbtn);
		GridBagConstraints gbc_refresh = new GridBagConstraints();
		gbc_refresh.gridx = 2;
		gbc_refresh.gridy = 4;
		contentPane.add(refresh, gbc_refresh);
	}
	
	public void Refreshlist(DefaultListModel itemmodel) {
		if(OwO == null)
			return;
		itemmodel.clear();
		for(String it:OwO.ma.getAllstock()) {
			itemmodel.addElement(it);
		}
	}
}
