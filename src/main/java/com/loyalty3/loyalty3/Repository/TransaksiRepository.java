package com.loyalty3.loyalty3.Repository;

import com.loyalty3.loyalty3.Entity.TransaksiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaksiRepository extends JpaRepository<TransaksiEntity, Long> {
}
