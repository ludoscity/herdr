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

package com.ludoscity.herdr.common.data

import kotlin.coroutines.Continuation
import kotlin.coroutines.suspendCoroutine

actual open class SecureDataStore actual constructor() {
    actual suspend fun storeString(key: String, data: String) {
        return suspendCoroutine { continuation ->
            putString(key, data, continuation)
        }
    }

    actual suspend fun retrieveString(key: String): String? {
        return suspendCoroutine { continuation ->
            getString(key, continuation)
        }
    }

    actual suspend fun deleteKey(key: String) {
        return suspendCoroutine { continuation ->
            deleteKey(key, continuation)
        }
    }

    open fun putString(key: String, data: String, callback: Continuation<Unit>) {
        throw NotImplementedError("iOS project should implement this")
    }

    open fun getString(key: String, callback: Continuation<String>) {
        throw NotImplementedError("iOS project should implement this")
    }

    open fun deleteKey(key: String, callback: Continuation<Unit>) {
        throw NotImplementedError("iOS project should implement this")
    }

    actual suspend fun storeLong(key: String, data: Long) {
    }

    actual suspend fun retrieveLong(key: String): Long? {
        TODO("Not yet implemented")
    }

    actual suspend fun storeBoolean(key: String, data: Boolean) {
    }

    actual suspend fun retrieveBoolean(key: String): Boolean? {
        TODO("Not yet implemented")
    }
}