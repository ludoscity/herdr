/*
 *     Copyright (c) 2020. f8full https://github.com/f8full
 *     Herdr is a privacy conscious multiplatform mobile data collector
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ludoscity.herdr.common.domain.usecase.analytics

import com.ludoscity.herdr.common.base.Response
import com.ludoscity.herdr.common.data.AnalTrackingDatapoint
import com.ludoscity.herdr.common.data.repository.AnalTrackingRepository
import com.ludoscity.herdr.common.domain.usecase.base.BaseUseCaseAsync
import org.koin.core.KoinComponent
import org.koin.core.inject

class SaveAnalyticsDatapointUseCaseAsync : KoinComponent,
    BaseUseCaseAsync<SaveAnalyticsDatapointUseCaseInput, List<AnalTrackingDatapoint>>() {
    private val repo: AnalTrackingRepository by inject()
    override suspend fun run(): Response<List<AnalTrackingDatapoint>> {
        return repo.insertAnalTrackingDatapoint(input!!.toSave)
    }
}