# ecommerce-microservizi

Progetto di studio su Spring Boot e microservizi.

| Servizio | Porta | Database | Responsabilità |
|---|---|---|---|
| `e-commerce` | 8080 | `ecommercedb` | ordini |
| `prodotti` | 8081 | `prodottidb` | catalogo prodotti |
| `auth` *(in arrivo)* | 8082 | `authdb` | utenti, login, token JWT |

Ogni servizio è un progetto Maven indipendente: si avvia dalla sua cartella con `./mvnw spring-boot:run`.
