package Forms;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.regex.Pattern;

/**
 * Created by Sanket on 05-02-2017.
 */
public class BasicForm {
    protected JTextField nameTextField;
    private JLabel nameLabel;
    private JLabel organisationNameLabel;
    protected JTextField organizationNameTextField;
    protected JTextField positionTextField;
    private JLabel positionLabel;
    protected JTextField voiceTelephoneTextField;
    protected JTextField tDD_TTYTelephoneTextField;
    protected JTextField facsimileTelephoneTextField;
    private JLabel voiceTelephoneLabel;
    private JLabel tDD_TYYTelephoneLabel;
    private JLabel facsimileTelephoneLabel;
    private JLabel addressLabel;
    protected JButton addAddress;
    private JButton addVoiceTelephoneButton;
    private JButton addTDD_TTYTelephoneButton;
    private JButton addFacsimileTelephoneButton;
    protected JTextField hoursTextField;
    private JLabel hoursOfServiceLabel;
    protected JTextField instructionTextField;
    private JLabel instructionLabel;
    private JButton cancelButton;
    private JButton saveButton;
    protected JPanel form;
    private JLabel primaryInfo;
    private JLabel addressInfo;
    private JLabel contactInfo;
    private JLabel serviceInfo;
    protected JTextField emailTextField;
    private JButton addEmailButton;
    private JLabel emailLabel;
    protected JComboBox addressComboBox;
    protected JComboBox voiceTelephoneComboBox;
    protected JComboBox tDDTelephoneComboBox;
    protected JComboBox facsimileTelephoneComboBox;
    protected JComboBox emailComboBox;
    private JButton removeEmailButton;
    private JButton removeFacsimileTelephoneButton;
    private JButton removeTDDTelephoneButton;
    private JButton removeVoiceTelephoneButton;
    private JButton removeAddressButton;
    private static JFrame emptyFrame;
    protected Boolean nameTextFieldValid = false;
    protected Boolean organizationNameTextFieldValid = false;
    protected Boolean positionTextFieldValid = false;
    protected Boolean voiceTelephoneTextFieldValid = false;
    protected Boolean tDD_TTYTelephoneTextFieldValid = false;
    protected Boolean facsimileTelephoneTextFieldValid = false;
    protected Boolean emailTextFieldValid = false;
    protected Boolean hoursTextFieldValid = false;
    protected Boolean instructionTextFieldValid = false;

    public BasicForm() {
        addAddress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAddress.setEnabled(false);
                Address address = new Address();
                address.generate();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyFrame.dispose();
                CreateForm form = new CreateForm();
                form.initialForm();

            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateForm createForm = new CreateForm();
                // Checks invalidation
                if (!nameTextFieldValid || !organizationNameTextFieldValid || addressComboBox.getItemCount() == 1
                        || ((LineBorder) positionTextField.getBorder()).getLineColor().equals(Color.RED)
                        || ((LineBorder) tDD_TTYTelephoneTextField.getBorder()).getLineColor().equals(Color.RED)
                        || ((LineBorder) facsimileTelephoneTextField.getBorder()).getLineColor().equals(Color.RED)
                        || ((LineBorder) emailTextField.getBorder()).getLineColor().equals(Color.RED)
                        || ((LineBorder) hoursTextField.getBorder()).getLineColor().equals(Color.RED)
                        || (((LineBorder) voiceTelephoneTextField.getBorder()).getLineColor().equals(Color.RED) && voiceTelephoneComboBox.getItemCount() == 1)
                        )
                    JOptionPane.showMessageDialog(emptyFrame, "TextBoxes Marked in RED are either EMPTY or INCORRECT");

                else {
                    createForm.submitForm();
                    emptyFrame.dispose();
                    createForm.initialForm();
                }
            }
        });
        nameTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (nameTextField.getText().equals("Enter Name")) nameTextField.setText("");
                nameTextField.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
            }
        });
        nameTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (Pattern.matches("([a-zA-Z][a-zA-Z]*[.]?[ ]?)*[a-zA-Z][a-zA-Z]*", nameTextField.getText())) {
                    nameTextFieldValid = true;
                    nameTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                } else if (nameTextField.getText().length() == 0) {
                    nameTextFieldValid = false;
                    nameTextField.setText("Enter Name");
                    nameTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    nameTextFieldValid = false;
                    nameTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
        organizationNameTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (organizationNameTextField.getText().equals("Enter Organization Name"))
                    organizationNameTextField.setText("");
                organizationNameTextField.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
            }
        });
        organizationNameTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (Pattern.matches("([a-zA-Z0-9][a-zA-Z0-9]*[.]?[ ]?)*[a-zA-Z0-9][a-zA-Z0-9]*", organizationNameTextField.getText())) {
                    organizationNameTextFieldValid = true;
                    organizationNameTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                } else if (organizationNameTextField.getText().length() == 0) {
                    organizationNameTextFieldValid = false;
                    organizationNameTextField.setText("Enter Organization Name");
                    organizationNameTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    organizationNameTextFieldValid = false;
                    organizationNameTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
        positionTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (positionTextField.getText().equals("Enter Position")) positionTextField.setText("");
                positionTextField.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
            }
        });
        positionTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (Pattern.matches("([a-zA-Z0-9][a-zA-Z0-9]*[.]?[ ]?)*[a-zA-Z0-9][a-zA-Z0-9]*", positionTextField.getText())) {
                    positionTextFieldValid = true;
                    positionTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                } else if (positionTextField.getText().length() == 0) {
                    positionTextFieldValid = false;
                    positionTextField.setText("Enter Position");
                    positionTextField.setBorder(BorderFactory.createLineBorder(Color.gray));
                } else {
                    positionTextFieldValid = false;
                    positionTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
        voiceTelephoneTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (voiceTelephoneTextField.getText().equals("Enter Voice Telephone"))
                    voiceTelephoneTextField.setText("");
                voiceTelephoneTextField.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
            }
        });
        voiceTelephoneTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (Pattern.matches("[1-9][0-9]*", voiceTelephoneTextField.getText()) && voiceTelephoneTextField.getText().length() == 10) {
                    voiceTelephoneTextFieldValid = true;
                    voiceTelephoneTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                } else if (voiceTelephoneTextField.getText().length() == 0 && voiceTelephoneComboBox.getItemCount() > 1) {
                    voiceTelephoneTextFieldValid = false;
                    voiceTelephoneTextField.setBorder(BorderFactory.createLineBorder(Color.gray));
                    voiceTelephoneTextField.setText("Enter Voice Telephone");
                } else if (voiceTelephoneTextField.getText().length() == 0 && voiceTelephoneComboBox.getItemCount() == 1) {
                    voiceTelephoneTextFieldValid = false;
                    voiceTelephoneTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                    voiceTelephoneTextField.setText("Enter Voice Telephone");
                } else {
                    voiceTelephoneTextFieldValid = false;
                    voiceTelephoneTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
        tDD_TTYTelephoneTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (tDD_TTYTelephoneTextField.getText().equals("Enter TDD_TTY Telephone"))
                    tDD_TTYTelephoneTextField.setText("");
                tDD_TTYTelephoneTextField.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
            }
        });
        tDD_TTYTelephoneTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (Pattern.matches("[1-9][0-9]*", tDD_TTYTelephoneTextField.getText()) && tDD_TTYTelephoneTextField.getText().length() == 10) {
                    tDD_TTYTelephoneTextFieldValid = true;
                    tDD_TTYTelephoneTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                } else if (tDD_TTYTelephoneTextField.getText().length() == 0) {
                    tDD_TTYTelephoneTextFieldValid = false;
                    tDD_TTYTelephoneTextField.setBorder(BorderFactory.createLineBorder(Color.gray));
                    tDD_TTYTelephoneTextField.setText("Enter TDD_TTY Telephone");
                } else {
                    tDD_TTYTelephoneTextFieldValid = false;
                    tDD_TTYTelephoneTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
        facsimileTelephoneTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (facsimileTelephoneTextField.getText().equals("Enter Facsimile Telephone"))
                    facsimileTelephoneTextField.setText("");
                facsimileTelephoneTextField.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
            }
        });
        facsimileTelephoneTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (Pattern.matches("[1-9][0-9]*", facsimileTelephoneTextField.getText()) && facsimileTelephoneTextField.getText().length() == 10) {
                    facsimileTelephoneTextFieldValid = true;
                    facsimileTelephoneTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                } else if (facsimileTelephoneTextField.getText().length() == 0) {
                    facsimileTelephoneTextFieldValid = false;
                    facsimileTelephoneTextField.setBorder(BorderFactory.createLineBorder(Color.gray));
                    facsimileTelephoneTextField.setText("Enter Facsimile Telephone");
                } else {
                    facsimileTelephoneTextFieldValid = false;
                    facsimileTelephoneTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
        emailTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (emailTextField.getText().equals("Enter Email")) emailTextField.setText("");
                emailTextField.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
            }
        });
        emailTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
                if (Pattern.matches(regex, emailTextField.getText())) {
                    emailTextFieldValid = true;
                    emailTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                } else if (emailTextField.getText().length() == 0) {
                    emailTextFieldValid = false;
                    emailTextField.setBorder(BorderFactory.createLineBorder(Color.gray));
                    emailTextField.setText("Enter Email");
                } else {
                    emailTextFieldValid = false;
                    emailTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
        hoursTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (hoursTextField.getText().equals("Enter Hours")) hoursTextField.setText("");
                hoursTextField.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
            }
        });
        hoursTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (Pattern.matches("[1-9][0-9]*", hoursTextField.getText())) {
                    hoursTextFieldValid = true;
                    hoursTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                } else if (hoursTextField.getText().length() == 0) {
                    hoursTextFieldValid = false;
                    hoursTextField.setText("Enter Hours");
                    hoursTextField.setBorder(BorderFactory.createLineBorder(Color.gray));
                } else {
                    hoursTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
        instructionTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (instructionTextField.getText().equals("Enter Instruction")) instructionTextField.setText("");
                instructionTextField.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

            }
        });
        instructionTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (instructionTextField.getText().length() == 0) {
                    instructionTextFieldValid = false;
                    instructionTextField.setText("Enter Instruction");
                    instructionTextField.setBorder(BorderFactory.createLineBorder(Color.gray));
                } else {
                    instructionTextFieldValid = true;
                    instructionTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                }
            }
        });
        removeAddressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addressComboBox.getSelectedIndex() != 0) {
                    CreateForm createForm = new CreateForm();
                    createForm.removeAddress(addressComboBox.getSelectedIndex() - 1);
                    addressComboBox.removeItemAt(addressComboBox.getSelectedIndex());
                }
            }
        });
        addVoiceTelephoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (voiceTelephoneTextFieldValid) {
                    voiceTelephoneComboBox.addItem(voiceTelephoneTextField.getText());
                    voiceTelephoneTextFieldValid = false;
                    voiceTelephoneTextField.setText("Enter Voice Telephone");
                }
            }
        });
        removeVoiceTelephoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (voiceTelephoneComboBox.getSelectedIndex() != 0)
                    voiceTelephoneComboBox.removeItemAt(voiceTelephoneComboBox.getSelectedIndex());
            }
        });
        addTDD_TTYTelephoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tDD_TTYTelephoneTextFieldValid) {
                    tDDTelephoneComboBox.addItem(tDD_TTYTelephoneTextField.getText());
                    tDD_TTYTelephoneTextFieldValid = false;
                    tDD_TTYTelephoneTextField.setText("Enter TDD_TTY Telephone");
                }
            }
        });
        removeTDDTelephoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tDDTelephoneComboBox.getSelectedIndex() != 0)
                    tDDTelephoneComboBox.removeItemAt(tDDTelephoneComboBox.getSelectedIndex());
            }
        });
        addFacsimileTelephoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (facsimileTelephoneTextFieldValid) {
                    facsimileTelephoneComboBox.addItem(facsimileTelephoneTextField.getText());
                    facsimileTelephoneTextFieldValid = false;
                    facsimileTelephoneTextField.setText("Enter Facsimile Telephone");
                }
            }
        });
        removeFacsimileTelephoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (facsimileTelephoneComboBox.getSelectedIndex() != 0)
                    facsimileTelephoneComboBox.removeItemAt(facsimileTelephoneComboBox.getSelectedIndex());
            }
        });
        addEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (emailTextFieldValid) {
                    emailComboBox.addItem(emailTextField.getText());
                    emailTextFieldValid = false;
                    emailTextField.setText("Enter Email");
                }
            }
        });
        removeEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (emailComboBox.getSelectedIndex() != 0)
                    emailComboBox.removeItemAt(emailComboBox.getSelectedIndex());
            }
        });
    }

    public void generate(BasicForm basicForm) {
        emptyFrame = new JFrame("BasicForm");
        emptyFrame.setContentPane(basicForm.form);
        emptyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        emptyFrame.setResizable(false);
        emptyFrame.setSize(600, 700);
        emptyFrame.setVisible(true);
        emptyFrame.setLocationRelativeTo(null);
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
        form = new JPanel();
        form.setLayout(new GridBagLayout());
        form.setMaximumSize(new Dimension(1000, 1000));
        form.setMinimumSize(new Dimension(360, 600));
        form.setPreferredSize(new Dimension(600, 600));
        form.setRequestFocusEnabled(true);
        nameLabel = new JLabel();
        nameLabel.setText("Name *");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(nameLabel, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(spacer1, gbc);
        nameTextField = new JTextField();
        nameTextField.setText("Enter Name");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(nameTextField, gbc);
        organisationNameLabel = new JLabel();
        organisationNameLabel.setText("Organisation Name *");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(organisationNameLabel, gbc);
        organizationNameTextField = new JTextField();
        organizationNameTextField.setText("Enter Organization Name");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(organizationNameTextField, gbc);
        positionLabel = new JLabel();
        positionLabel.setText("Position");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(positionLabel, gbc);
        positionTextField = new JTextField();
        positionTextField.setText("Enter Position");
        positionTextField.setToolTipText("Your Current Position in Oraganization");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(positionTextField, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer3, gbc);
        addressLabel = new JLabel();
        addressLabel.setText("Address *");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(addressLabel, gbc);
        voiceTelephoneLabel = new JLabel();
        voiceTelephoneLabel.setText("Voice Telephone *");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 19;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(voiceTelephoneLabel, gbc);
        voiceTelephoneTextField = new JTextField();
        voiceTelephoneTextField.setText("Enter Voice Telephone");
        voiceTelephoneTextField.setToolTipText("Enter 10 digit Voice Telephone Number");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 19;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(voiceTelephoneTextField, gbc);
        tDD_TYYTelephoneLabel = new JLabel();
        tDD_TYYTelephoneLabel.setText("TDD/TYY Telephone");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 23;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(tDD_TYYTelephoneLabel, gbc);
        tDD_TTYTelephoneTextField = new JTextField();
        tDD_TTYTelephoneTextField.setText("Enter TDD_TTY Telephone");
        tDD_TTYTelephoneTextField.setToolTipText("Enter 10 digit TDD/TTY Telephone Number");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 23;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(tDD_TTYTelephoneTextField, gbc);
        facsimileTelephoneLabel = new JLabel();
        facsimileTelephoneLabel.setText("Facsimile Telephone");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 27;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(facsimileTelephoneLabel, gbc);
        facsimileTelephoneTextField = new JTextField();
        facsimileTelephoneTextField.setText("Enter Facsimile Telephone");
        facsimileTelephoneTextField.setToolTipText("Enter 10 digit Facsimile Telephone Number");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 27;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(facsimileTelephoneTextField, gbc);
        addAddress = new JButton();
        addAddress.setText("Add New Address");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 12;
        form.add(addAddress, gbc);
        hoursOfServiceLabel = new JLabel();
        hoursOfServiceLabel.setText("Hours of Service");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 38;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(hoursOfServiceLabel, gbc);
        hoursTextField = new JTextField();
        hoursTextField.setText("Enter Hours");
        hoursTextField.setToolTipText("Enter No. of Hours");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 38;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(hoursTextField, gbc);
        instructionLabel = new JLabel();
        instructionLabel.setText("Instruction");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 40;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(instructionLabel, gbc);
        instructionTextField = new JTextField();
        instructionTextField.setEditable(true);
        instructionTextField.setEnabled(true);
        instructionTextField.setName("");
        instructionTextField.setText("Enter Instruction");
        instructionTextField.setToolTipText("How do you wish to be Contacted");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 40;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(instructionTextField, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 39;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 30;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 26;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer6, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 22;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer7, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 15;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer8, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer9, gbc);
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 42;
        form.add(cancelButton, gbc);
        saveButton = new JButton();
        saveButton.setHideActionText(false);
        saveButton.setText("Save");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 42;
        gbc.anchor = GridBagConstraints.EAST;
        form.add(saveButton, gbc);
        final JPanel spacer10 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 41;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer10, gbc);
        final JSeparator separator1 = new JSeparator();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        form.add(separator1, gbc);
        primaryInfo = new JLabel();
        primaryInfo.setText("Primary Information");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(primaryInfo, gbc);
        final JPanel spacer11 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer11, gbc);
        addressInfo = new JLabel();
        addressInfo.setText("Address Information");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(addressInfo, gbc);
        final JSeparator separator2 = new JSeparator();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.BOTH;
        form.add(separator2, gbc);
        final JPanel spacer12 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer12, gbc);
        contactInfo = new JLabel();
        contactInfo.setText("Contact Information");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 16;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(contactInfo, gbc);
        final JSeparator separator3 = new JSeparator();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 17;
        gbc.fill = GridBagConstraints.BOTH;
        form.add(separator3, gbc);
        final JPanel spacer13 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 18;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer13, gbc);
        serviceInfo = new JLabel();
        serviceInfo.setText("Service Information");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 35;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(serviceInfo, gbc);
        final JSeparator separator4 = new JSeparator();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 36;
        gbc.fill = GridBagConstraints.BOTH;
        form.add(separator4, gbc);
        final JPanel spacer14 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 37;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer14, gbc);
        emailLabel = new JLabel();
        emailLabel.setText("Email");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 31;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(emailLabel, gbc);
        final JPanel spacer15 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 34;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer15, gbc);
        emailTextField = new JTextField();
        emailTextField.setText("Enter Email");
        emailTextField.setToolTipText("Enter Email (youremail@domain)");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 31;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(emailTextField, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("* Marked Fields are Mandatory");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 44;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(label1, gbc);
        addVoiceTelephoneButton = new JButton();
        addVoiceTelephoneButton.setText("Add New");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 21;
        form.add(addVoiceTelephoneButton, gbc);
        addTDD_TTYTelephoneButton = new JButton();
        addTDD_TTYTelephoneButton.setText("Add New");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 25;
        form.add(addTDD_TTYTelephoneButton, gbc);
        addFacsimileTelephoneButton = new JButton();
        addFacsimileTelephoneButton.setText("Add New");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 29;
        form.add(addFacsimileTelephoneButton, gbc);
        addEmailButton = new JButton();
        addEmailButton.setText("Add New");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 33;
        form.add(addEmailButton, gbc);
        addressComboBox = new JComboBox();
        addressComboBox.setEditable(false);
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Select Address");
        addressComboBox.setModel(defaultComboBoxModel1);
        addressComboBox.setToolTipText("Address Already Added");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 12;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(addressComboBox, gbc);
        final JPanel spacer16 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 12;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(spacer16, gbc);
        final JPanel spacer17 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 20;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer17, gbc);
        final JPanel spacer18 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 32;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer18, gbc);
        final JPanel spacer19 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 28;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer19, gbc);
        final JPanel spacer20 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 24;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer20, gbc);
        final JPanel spacer21 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 43;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer21, gbc);
        voiceTelephoneComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("Select Telephone");
        voiceTelephoneComboBox.setModel(defaultComboBoxModel2);
        voiceTelephoneComboBox.setToolTipText("Numbers Already Added");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 19;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(voiceTelephoneComboBox, gbc);
        tDDTelephoneComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("Select Telephone");
        tDDTelephoneComboBox.setModel(defaultComboBoxModel3);
        tDDTelephoneComboBox.setToolTipText("Numbers Already Added");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 23;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(tDDTelephoneComboBox, gbc);
        facsimileTelephoneComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
        defaultComboBoxModel4.addElement("Select Telephone");
        facsimileTelephoneComboBox.setModel(defaultComboBoxModel4);
        facsimileTelephoneComboBox.setToolTipText("Numbers Already Added");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 27;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(facsimileTelephoneComboBox, gbc);
        emailComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel5 = new DefaultComboBoxModel();
        defaultComboBoxModel5.addElement("Select Email");
        emailComboBox.setModel(defaultComboBoxModel5);
        emailComboBox.setToolTipText("Emails Already Added");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 31;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(emailComboBox, gbc);
        removeEmailButton = new JButton();
        removeEmailButton.setText("Remove");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 33;
        form.add(removeEmailButton, gbc);
        removeFacsimileTelephoneButton = new JButton();
        removeFacsimileTelephoneButton.setText("Remove");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 29;
        form.add(removeFacsimileTelephoneButton, gbc);
        removeTDDTelephoneButton = new JButton();
        removeTDDTelephoneButton.setText("Remove");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 25;
        form.add(removeTDDTelephoneButton, gbc);
        removeVoiceTelephoneButton = new JButton();
        removeVoiceTelephoneButton.setText("Remove");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 21;
        form.add(removeVoiceTelephoneButton, gbc);
        removeAddressButton = new JButton();
        removeAddressButton.setText("Remove");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 14;
        form.add(removeAddressButton, gbc);
        final JPanel spacer22 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 13;
        gbc.fill = GridBagConstraints.VERTICAL;
        form.add(spacer22, gbc);
        final JPanel spacer23 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 24;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(spacer23, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return form;
    }
}

