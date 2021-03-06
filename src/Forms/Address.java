package Forms;

import Compound.AddressInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Sanket on 05-02-2017.
 */
public class Address {
    private JLabel addressType;
    protected JComboBox addressTypecomboBox;
    private JLabel address;
    protected JTextField addressTextField;
    private JLabel city;
    private JLabel state;
    private JLabel country;
    private JLabel pincode;
    protected JTextField cityTextField;
    protected JTextField stateTextField;
    protected JTextField countryTextField;
    protected JTextField pincodeTextField;
    protected JPanel addressPanel;
    private JButton cancelButton;
    private JButton addButton;
    private JLabel addressDetailsLabel;
    private static JFrame addressFrame;
    private Boolean addressTextFieldValid = false;
    private Boolean stateTextFieldValid = false;
    private Boolean cityTextFieldValid = false;
    private Boolean countryTextFieldValid = false;
    private Boolean pincodeTextFieldValid = false;

    public Address() {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addressFrame.dispose();
                CreateForm createForm = new CreateForm();
                createForm.getBasicForm().addAddress.setEnabled(true);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateForm createForm = new CreateForm();
                if (!addressTextFieldValid || !cityTextFieldValid || !stateTextFieldValid || !countryTextFieldValid || !pincodeTextFieldValid) {
                    if (!addressTextFieldValid) addressTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                    if (!cityTextFieldValid) cityTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                    if (!stateTextFieldValid) stateTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                    if (!countryTextFieldValid) countryTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                    if (!pincodeTextFieldValid) pincodeTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                    JOptionPane.showMessageDialog(addressFrame, "Empty Fields");
                }

                else {
                    createForm.storeAddress(addressTypecomboBox.getSelectedItem().toString(), addressTextField.getText(),
                            cityTextField.getText(), stateTextField.getText(), countryTextField.getText(), pincodeTextField.getText());

                    addressFrame.dispose();
                    createForm.getBasicForm().addAddress.setEnabled(true);
                }
            }
        });
        addressTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (addressTextField.getText().equals("Enter Address")) addressTextField.setText("");
                addressTextField.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

            }
        });
        addressTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (Pattern.matches("([a-zA-Z0-9/-][a-zA-Z0-9/-]*[.]?[,]?[ ]?)*[a-zA-Z0-9/-][a-zA-Z0-9/-]*[.]?", addressTextField.getText())) {
                    addressTextFieldValid = true;
                    addressTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                } else if (addressTextField.getText().length() == 0) {
                    addressTextFieldValid = false;
                    addressTextField.setText("Enter Address");
                    addressTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    addressTextFieldValid = false;
                    addressTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
        cityTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (cityTextField.getText().equals("Enter City")) cityTextField.setText("");
                cityTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
            }
        });
        cityTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (Pattern.matches("([A-Z][a-zA-Z]*[.]?[ ]?)*[a-zA-Z][a-zA-Z]*[.]?", cityTextField.getText())) {
                    cityTextFieldValid = true;
                    cityTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                } else if (cityTextField.getText().length() == 0) {
                    cityTextFieldValid = false;
                    cityTextField.setText("Enter City");
                    cityTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    cityTextFieldValid = false;
                    cityTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
        stateTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (stateTextField.getText().equals("Enter State")) stateTextField.setText("");
                stateTextField.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
            }
        });
        stateTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (Pattern.matches("([A-Z][a-zA-Z]*[.]?[ ]?)*[a-zA-Z][a-zA-Z]*[.]?", stateTextField.getText())) {
                    stateTextFieldValid = true;
                    stateTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                } else if (stateTextField.getText().length() == 0) {
                    stateTextFieldValid = false;
                    stateTextField.setText("Enter State");
                    stateTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    stateTextFieldValid = false;
                    stateTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
        countryTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (countryTextField.getText().equals("Enter Country")) countryTextField.setText("");
                countryTextField.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
            }
        });
        countryTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (Pattern.matches("([A-Z][a-zA-Z]*[.]?[ ]?)*[a-zA-Z][a-zA-Z]*[.]?", countryTextField.getText())) {
                    countryTextFieldValid = true;
                    countryTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                } else if (countryTextField.getText().length() == 0) {
                    countryTextFieldValid = false;
                    countryTextField.setText("Enter Country");
                    countryTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    countryTextFieldValid = false;
                    countryTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
        pincodeTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (pincodeTextField.getText().equals("Enter PinCode")) pincodeTextField.setText("");
                pincodeTextField.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
            }
        });
        pincodeTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (Pattern.matches("^[0-9]*", pincodeTextField.getText()) && pincodeTextField.getText().length() == 6) {
                    pincodeTextFieldValid = true;
                    pincodeTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                } else if (pincodeTextField.getText().length() == 0) {
                    pincodeTextFieldValid = false;
                    pincodeTextField.setText("Enter PinCode");
                    pincodeTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    pincodeTextFieldValid = false;
                    pincodeTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
                ;
            }
        });
    }

    public void generate() {
        addressFrame = new JFrame("Address");
        addressFrame.setContentPane(new Address().addressPanel);
        addressFrame.setDefaultCloseOperation(addressFrame.DO_NOTHING_ON_CLOSE);
        addressFrame.setResizable(false);
        addressFrame.setSize(400, 400);
        addressFrame.setVisible(true);
        addressFrame.setLocationRelativeTo(null);
        setAllBorder();
    }

    public void setAllBorder() {
        addressTextField.setBorder(BorderFactory.createLineBorder(Color.gray));
        cityTextField.setBorder(BorderFactory.createLineBorder(Color.gray));
        stateTextField.setBorder(BorderFactory.createLineBorder(Color.gray));
        countryTextField.setBorder(BorderFactory.createLineBorder(Color.gray));
        pincodeTextField.setBorder(BorderFactory.createLineBorder(Color.gray));

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        addressPanel = new JPanel();
        addressPanel.setLayout(new GridBagLayout());
        addressType = new JLabel();
        addressType.setText("Address Type");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        addressPanel.add(addressType, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addressPanel.add(spacer1, gbc);
        address = new JLabel();
        address.setText("Address *");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        addressPanel.add(address, gbc);
        city = new JLabel();
        city.setText("City *");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        addressPanel.add(city, gbc);
        state = new JLabel();
        state.setText("State *");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        addressPanel.add(state, gbc);
        country = new JLabel();
        country.setText("Country *");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.WEST;
        addressPanel.add(country, gbc);
        pincode = new JLabel();
        pincode.setFocusable(true);
        pincode.setText("Pincode *");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.anchor = GridBagConstraints.WEST;
        addressPanel.add(pincode, gbc);
        cityTextField = new JTextField();
        cityTextField.setEnabled(true);
        cityTextField.setText("Enter City");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addressPanel.add(cityTextField, gbc);
        stateTextField = new JTextField();
        stateTextField.setText("Enter State");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addressPanel.add(stateTextField, gbc);
        countryTextField = new JTextField();
        countryTextField.setText("Enter Country");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addressPanel.add(countryTextField, gbc);
        pincodeTextField = new JTextField();
        pincodeTextField.setEditable(true);
        pincodeTextField.setText("Enter PinCode");
        pincodeTextField.setToolTipText("6 Digit VALID ZipCode");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 13;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addressPanel.add(pincodeTextField, gbc);
        addressTextField = new JTextField();
        addressTextField.setText("Enter Address");
        addressTextField.setToolTipText("House No. and Street Name");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addressPanel.add(addressTextField, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        addressPanel.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        addressPanel.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.VERTICAL;
        addressPanel.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.VERTICAL;
        addressPanel.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 12;
        gbc.fill = GridBagConstraints.VERTICAL;
        addressPanel.add(spacer6, gbc);
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 15;
        addressPanel.add(cancelButton, gbc);
        addButton = new JButton();
        addButton.setText("Add");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.anchor = GridBagConstraints.EAST;
        addressPanel.add(addButton, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 14;
        gbc.fill = GridBagConstraints.VERTICAL;
        addressPanel.add(spacer7, gbc);
        addressDetailsLabel = new JLabel();
        addressDetailsLabel.setText("Enter Your Address Details");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        addressPanel.add(addressDetailsLabel, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        addressPanel.add(spacer8, gbc);
        final JSeparator separator1 = new JSeparator();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        addressPanel.add(separator1, gbc);
        addressTypecomboBox = new JComboBox();
        addressTypecomboBox.setEditable(false);
        addressTypecomboBox.setMaximumRowCount(3);
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Mailing");
        defaultComboBoxModel1.addElement("Physical");
        defaultComboBoxModel1.addElement("Mailing & Physical");
        addressTypecomboBox.setModel(defaultComboBoxModel1);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addressPanel.add(addressTypecomboBox, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return addressPanel;
    }
}
