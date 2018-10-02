package restlabpackage.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import restlabpackage.Picture;

public interface PictureMongoRepository extends MongoRepository<Picture, String> {

}
