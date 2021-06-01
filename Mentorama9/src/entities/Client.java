package entities;

public class Client {
    private String ClientName;
    private Integer Shoppings;
    private boolean ClientStatus;
    private String ClientPasswrd;

    public Client(String clientName, Integer shoppings, boolean clientStatus, String clientPasswrd) {
        ClientName = clientName;
        Shoppings = shoppings;
        ClientStatus = clientStatus;
        ClientPasswrd = clientPasswrd;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public Integer getShoppings() {
        return Shoppings;
    }

    public void setShoppings(Integer shoppings) {
        Shoppings = shoppings;
    }

    public boolean isClientStatus() {
        return ClientStatus;
    }

    public void setClientStatus(boolean clientStatus) {
        ClientStatus = clientStatus;
    }

    public String getClientPasswrd() {
        return ClientPasswrd;
    }

    public void setClientPasswrd(String clientPasswrd) {
        ClientPasswrd = clientPasswrd;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ClientName='" + ClientName + '\'' +
                ", Shoppings=" + Shoppings +
                ", ClientStatus=" + ClientStatus +
                ", ClientPasswrd='" + ClientPasswrd + '\'' +
                '}';
    }
}

