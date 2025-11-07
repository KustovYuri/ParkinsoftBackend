package com.parkinsoft.backend.service

import com.parkinsoft.backend.models.entity.TestPreview
import com.parkinsoft.backend.repository.TestPreviewRepository
import org.springframework.stereotype.Service

@Service
class TestPreviewService(private val repository: TestPreviewRepository) {
    fun getAll(): List<TestPreview> = repository.findAll()

    fun getById(id: Long): TestPreview? = repository.findById(id).orElse(null)

    fun create(user: TestPreview): TestPreview = repository.save(user)

    fun delete(id: Long) = repository.deleteById(id)
}