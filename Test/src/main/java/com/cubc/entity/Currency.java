package com.cubc.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 這邊的 @Getter 與 @Setter 是 lombok 的功能, 不採用 @Data 在底下說明
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CURRENCY")
public class Currency implements Serializable {
    @Id
    @Column(name = "id", nullable = false, length = 10)
    private String id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;
}
