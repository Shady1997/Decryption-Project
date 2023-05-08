package controller;


import model.DecryptionModel;
import view.DecryptionView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DecryptionController implements PropertyChangeListener {

    private final DecryptionView view;
    private final DecryptionModel model;

    public DecryptionController(DecryptionView view, DecryptionModel model) {
        this.view = view;
        this.model = model;
        view.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("DecryptButtonClicked")) {
            try {
                String key = view.getKey();
                String encryptedText = view.getEncryptedText();
                String decryptedText = model.decrypt(key, encryptedText);
                view.setDecryptedText(decryptedText);
            } catch (Exception e) {
                view.displayErrorMessage("Error decrypting text: " + e.getMessage());
            }
        }
    }
}

