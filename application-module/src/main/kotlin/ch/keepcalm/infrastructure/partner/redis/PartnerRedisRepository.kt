package ch.keepcalm.infrastructure.partner.redis

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PartnerRedisRepository : CrudRepository<PartnerDTO, String>
