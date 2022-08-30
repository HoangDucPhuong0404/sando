package com.cg.team_project2.model;

import com.cg.team_project2.model.dto.LocationRegionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Table(name = "location_region")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class LocationRegion extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String provinceId;

    private String provinceName;

    private String districtId;

    private String districtName;

    private String wardId;

    private String wardName;

    private String address;

    @OneToOne(mappedBy = "locationRegion")
    private Order order;

    public LocationRegionDTO toLocationRegionDTO(){
        return new LocationRegionDTO().setId(id)
                .setProvinceId(provinceId)
                .setProvinceName(provinceName)
                .setDistrictId(districtId)
                .setDistrictName(districtName)
                .setWardId(wardId)
                .setWardName(wardName)
                .setAddress(address);
    }
}
