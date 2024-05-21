package github.pvp.manager;


import github.pvp.account.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class AccountManager {

    private final Map<UUID, Account> map = new ConcurrentHashMap<>();

    public void save(Account account) {
        map.put(account.getId(), account);
    }

    public Account read(UUID id) {
        return map.get(id);
    }

    public void delete(UUID id) {
        map.remove(id);
    }

    public List<Account> list() {
        return new ArrayList<>(map.values());
    }
}
