package umc.spring.domain.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import umc.spring.domain.BaseTimeEntity;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.region.Region;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Builder
@AllArgsConstructor
public class Store extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 50)
    private String address;

    @ColumnDefault("0.0")
    private Float score;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mission> missionList = new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    public void setRegion(Region region) {
        if (region != null) {
            this.region = region;
        }
    }
}
