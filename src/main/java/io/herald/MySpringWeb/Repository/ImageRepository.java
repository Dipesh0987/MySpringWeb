package io.herald.MySpringWeb.Repository;

import io.herald.MySpringWeb.Model.ImageTable;
import io.herald.MySpringWeb.Model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageTable,Integer> {

}
