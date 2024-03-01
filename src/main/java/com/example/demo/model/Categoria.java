package com.example.demo.model;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categoria{
  	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCategoria;
  @Column(nullable = false)
  private String nombre;
  
}
