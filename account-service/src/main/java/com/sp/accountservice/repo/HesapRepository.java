package com.sp.accountservice.repo;

import com.sp.accountservice.entity.Hesap;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HesapRepository extends CassandraRepository<Hesap,String> {
}
