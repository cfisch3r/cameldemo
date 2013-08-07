package de.agiledojo.cameldemo.businessevent;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginBusinessEventRepository extends MongoRepository<LoginBusinessEvent, ObjectId> {

}
