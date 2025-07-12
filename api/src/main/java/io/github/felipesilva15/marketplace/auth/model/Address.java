package io.github.felipesilva15.marketplace.auth.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.felipesilva15.marketplace.common.model.BaseModel;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class Address extends BaseModel {
    @Id
    @Column()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80)
    private String name;

    @Column(name = "postal_code", length = 8)
    @JsonProperty("postal_code")
    private String postalCode;
    
    @Column(length = 80)
    private String street;

    @Column(length = 40)
    private String locality;

    @Column(length = 60)
    private String city;

    @Column(length = 40)
    private String region;

    @Column(name = "region_code", length = 2)
    @JsonProperty("region_code")
    private String regionCode;

    @Column(length = 10)
    private String number;

    @Column(length = 120)
    private String complement;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
