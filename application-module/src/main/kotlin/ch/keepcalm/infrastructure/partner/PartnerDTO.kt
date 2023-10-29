package ch.keepcalm.infrastructure.partner

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

// DTO
@RedisHash("partner")
class PartnerDTO(@Id val id: String, @Indexed val name: String)
